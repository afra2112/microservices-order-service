package org.microservice.orderservice.service.order;

import org.microservice.orderservice.controller.dto.OrderLineRequest;
import org.microservice.orderservice.entity.Order;
import org.microservice.orderservice.entity.OrderLine;
import org.springframework.stereotype.Service;

@Service
public class OrderLineMapper {

    public OrderLine requestToEntity(OrderLineRequest request){
        return OrderLine.builder()
                .orderLineId(request.orderLineId())
                .order(Order.builder()
                        .orderId(request.orderId())
                        .build())
                .productId(request.productId())
                .build();
    }
}
