package org.microservice.orderservice.service.order;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.microservice.orderservice.controller.dto.OrderLineRequest;
import org.microservice.orderservice.controller.dto.OrderRequest;
import org.microservice.orderservice.customer.CustomerClient;
import org.microservice.orderservice.entity.Order;
import org.microservice.orderservice.exception.BusinessException;
import org.microservice.orderservice.persistence.OrderRepository;
import org.microservice.orderservice.product.ProductClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerClient customerClient;
    private final OrderMapper orderMapper;
    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final OrderLineService orderLineService;

    public Long createOrder(@Valid OrderRequest request) {

        var customer = customerClient.getById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order. Not customer found by the provided id: " + request.customerId()));

        productClient.purchaseProducts(request.products());

        Order order = orderRepository.save(orderMapper.requestToOrder(request));

        request.products().forEach(product -> {
            orderLineService.saveOrderLine(
                    new OrderLineRequest(null, order.getOrderId(), product.productId(), product.quantity())
            );
        });

        return order.getOrderId();
    }
}
