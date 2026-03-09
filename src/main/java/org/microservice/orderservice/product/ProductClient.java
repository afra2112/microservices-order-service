package org.microservice.orderservice.product;

import org.microservice.orderservice.controller.dto.PurchaseRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@FeignClient(
        name = "product-service",
        url = "http://localhost:product-service/api/v1/products"
)
public interface ProductClient {

    @GetMapping()
    List<PurchaseResponse> purchaseProducts(@RequestBody List<PurchaseRequest> request);

}
