package org.microservice.orderservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.microservice.orderservice.controller.dto.OrderRequest;
import org.microservice.orderservice.controller.dto.OrderResponse;
import org.microservice.orderservice.service.order.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Long> createOrder(@RequestBody @Valid OrderRequest request){
        return ResponseEntity.ok(orderService.createOrder(request));
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> findAll(){
        return ResponseEntity.ok(orderService.findAll());
    }
}
