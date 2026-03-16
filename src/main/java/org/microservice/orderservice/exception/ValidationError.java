package org.microservice.orderservice.exception;

public record ValidationError(
        String field,
        String message
) {
}
