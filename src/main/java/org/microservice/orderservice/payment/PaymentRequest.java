package org.microservice.orderservice.payment;

import org.microservice.orderservice.customer.CustomerResponse;
import org.microservice.orderservice.entity.PaymentMethodEnum;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethodEnum paymentMethod,
        Long orderId,
        String orderReference,
        CustomerResponse customer
) {
}
