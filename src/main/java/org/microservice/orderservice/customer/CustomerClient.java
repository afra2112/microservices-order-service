package org.microservice.orderservice.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(
        name = "customer-service",
        url = "http://localhost:customer-service/api/v1/customers"
)
public interface CustomerClient {

    @GetMapping("/{customerId}")
    CustomerResponse getById(@PathVariable UUID customerId);

}
