package org.microservice.orderservice.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "orderlines")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderLineId;

    private Long productId;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;
}