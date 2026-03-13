package org.microservice.orderservice.controller.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderLineRequest(
        Long orderLineId,
        Long orderId,

        @NotNull
        Long productId,

        @Positive
        @NotNull
        Integer quantity
) {
}
