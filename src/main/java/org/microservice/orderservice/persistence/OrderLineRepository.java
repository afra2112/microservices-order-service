package org.microservice.orderservice.persistence;

import org.microservice.orderservice.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
    List<OrderLine> findAllByOrder_orderId(Long orderOrderId);
}
