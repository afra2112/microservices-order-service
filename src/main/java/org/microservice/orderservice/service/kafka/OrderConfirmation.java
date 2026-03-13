package org.microservice.orderservice.service.kafka;

import org.microservice.orderservice.customer.CustomerResponse;
import org.microservice.orderservice.entity.PaymentMethodEnum;
import org.microservice.orderservice.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethodEnum paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}
