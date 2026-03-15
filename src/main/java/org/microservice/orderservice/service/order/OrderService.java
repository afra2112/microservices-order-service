package org.microservice.orderservice.service.order;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.microservice.orderservice.controller.dto.OrderLineRequest;
import org.microservice.orderservice.controller.dto.OrderProducer;
import org.microservice.orderservice.controller.dto.OrderRequest;
import org.microservice.orderservice.customer.CustomerClient;
import org.microservice.orderservice.entity.Order;
import org.microservice.orderservice.exception.BusinessException;
import org.microservice.orderservice.payment.PaymentClient;
import org.microservice.orderservice.payment.PaymentRequest;
import org.microservice.orderservice.persistence.OrderRepository;
import org.microservice.orderservice.product.ProductClient;
import org.microservice.orderservice.product.PurchaseResponse;
import org.microservice.orderservice.service.kafka.OrderConfirmation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerClient customerClient;
    private final OrderMapper orderMapper;
    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;

    public Long createOrder(@Valid OrderRequest request) {

        var customer = customerClient.getById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order. Not customer found by the provided id: " + request.customerId()));

        List<PurchaseResponse> purchasedProducts = productClient.purchaseProducts(request.products());

        Order order = orderRepository.save(orderMapper.requestToOrder(request));

        request.products().forEach(product -> {
            orderLineService.saveOrderLine(
                    new OrderLineRequest(null, order.getOrderId(), product.productId(), product.quantity())
            );
        });

        paymentClient.requestOrderPayment(new PaymentRequest(
                request.amount(),
                order.getPaymentMethod(),
                order.getOrderId(),
                order.getReference(),
                customer
        ));

        orderProducer.SendOrderConfirmation(
                new OrderConfirmation(
                        request.reference(),
                        request.amount(),
                        request.paymentMethod(),
                        customer,
                        purchasedProducts
                )
        );

        return order.getOrderId();
    }
}
