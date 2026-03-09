package org.microservice.orderservice.product;

import java.util.UUID;

public record CustomerResponse(
        UUID customerId,
        String firstname,
        String lastname,
        String email
) {
}
