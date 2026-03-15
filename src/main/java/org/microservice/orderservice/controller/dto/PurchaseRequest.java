package org.microservice.orderservice.controller.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PurchaseRequest(
        @NotNull
        Long productId,

        @Positive
        Integer quantity
) {
}
