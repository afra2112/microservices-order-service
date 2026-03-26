package org.microservice.orderservice.product;

import org.microservice.orderservice.controller.dto.PurchaseRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@FeignClient(name = "product-service")
public interface ProductClient {

    @PostMapping("/api/v1/products/purchase")
    List<PurchaseResponse> purchaseProducts(@RequestBody List<PurchaseRequest> request);

}
