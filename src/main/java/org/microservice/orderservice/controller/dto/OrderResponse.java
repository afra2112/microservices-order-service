package org.microservice.orderservice.controller.dto;

import org.microservice.orderservice.entity.PaymentMethodEnum;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderResponse(
        Long orderId,
        String reference,
        BigDecimal amount,
        PaymentMethodEnum paymentMethod,
        UUID customerId
) {
}
