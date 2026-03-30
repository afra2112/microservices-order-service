package org.microservice.orderservice.customer;

public record CustomerResponse(
        String customerId,
        String firstname,
        String lastname,
        String email
) {
}
