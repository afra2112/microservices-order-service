package org.microservice.orderservice.payment;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "payment-service",
        url = "http://localhost:payment-service/api/v1/payment"
)
public interface PaymentClient {

    @PostMapping
    Long requestOrderPayment(@RequestBody PaymentRequest request);
}
