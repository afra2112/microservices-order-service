package org.microservice.orderservice.service.order;

import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.microservice.orderservice.controller.dto.OrderLineRequest;
import org.microservice.orderservice.controller.dto.OrderLineResponse;
import org.microservice.orderservice.persistence.OrderLineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderLineService {

    private final OrderLineRepository orderLineRepository;
    private final OrderLineMapper orderLineMapper;

    public Long saveOrderLine(OrderLineRequest orderLineRequest) {
        return orderLineRepository.save(
                orderLineMapper.requestToEntity(orderLineRequest)
        ).getOrderLineId();
    }

    public List<OrderLineResponse> findAllById(Long orderId) {
        return orderLineRepository.findAllByOrderId(orderId)
                .stream()
                .map(orderLineMapper::entityToResponse)
                .toList();
    }
}
