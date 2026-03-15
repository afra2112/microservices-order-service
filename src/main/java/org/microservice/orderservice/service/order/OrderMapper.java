package org.microservice.orderservice.service.order;

import org.microservice.orderservice.controller.dto.OrderRequest;
import org.microservice.orderservice.entity.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {

    public Order requestToOrder(OrderRequest request){
        return Order.builder()
                .orderId(request.id())
                .customerId(request.customerId())
                .reference(request.reference())
                .totalAmmount(request.amount())
                .paymentMethod(request.paymentMethod())
                .build();
    }
}
