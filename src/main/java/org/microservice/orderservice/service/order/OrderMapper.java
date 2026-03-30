package org.microservice.orderservice.service.order;

import org.microservice.orderservice.controller.dto.OrderRequest;
import org.microservice.orderservice.controller.dto.OrderResponse;
import org.microservice.orderservice.entity.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class OrderMapper {

    public Order requestToOrder(OrderRequest request){
        return Order.builder()
                .orderId(request.id())
                .customerId(request.customerId())
                .reference(request.reference())
                .totalAmount(request.amount())
                .paymentMethod(request.paymentMethod())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public OrderResponse entityToResponse(Order order){
        return new OrderResponse(
                order.getOrderId(),
                order.getReference(),
                order.getTotalAmount(),
                order.getPaymentMethod(),
                order.getCustomerId()
        );
    }
}
