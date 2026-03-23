package org.microservice.orderservice.controller.dto;

public record OrderLineResponse(
        Long orderLineId,
        Integer quantity
) {
}
