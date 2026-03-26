package org.microservice.orderservice.persistence;

import org.microservice.orderservice.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {

    @Query("SELECT ol FROM OrderLine ol WHERE ol.order.orderId = :orderId")
    List<OrderLine> findAllByOrderId(@Param("orderId") Long orderId);
}
