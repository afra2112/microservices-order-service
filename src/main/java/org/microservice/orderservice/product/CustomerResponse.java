package org.microservice.orderservice.product;

public record CustomerResponse(
        String customerId,
        String firstname,
        String lastname,
        String email
) {
}
