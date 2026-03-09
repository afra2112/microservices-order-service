package org.microservice.orderservice.controller.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.microservice.orderservice.entity.PaymentMethodEnum;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record OrderRequest(
        Long id,

        String reference,

        @Positive
        BigDecimal amount,

        @NotNull
        PaymentMethodEnum paymentMethod,

        @NotNull
        UUID customerId,

        @NotEmpty
        List<PurchaseRequest> products
) {
}
