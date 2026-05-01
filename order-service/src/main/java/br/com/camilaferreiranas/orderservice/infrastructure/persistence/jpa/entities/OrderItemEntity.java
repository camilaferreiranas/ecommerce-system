package br.com.camilaferreiranas.orderservice.infrastructure.persistence.jpa.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "order_item")
@Data
public class OrderItemEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String productId;

    private BigDecimal price;

    private Integer quantity;


    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;
}
