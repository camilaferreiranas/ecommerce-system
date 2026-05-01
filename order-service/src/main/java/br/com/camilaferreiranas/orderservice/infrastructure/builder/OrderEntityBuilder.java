package br.com.camilaferreiranas.orderservice.infrastructure.builder;

import br.com.camilaferreiranas.orderservice.domain.enums.Status;
import br.com.camilaferreiranas.orderservice.infrastructure.persistence.jpa.entities.OrderEntity;
import br.com.camilaferreiranas.orderservice.infrastructure.persistence.jpa.entities.OrderItemEntity;
import br.com.camilaferreiranas.orderservice.infrastructure.persistence.jpa.entities.UserEntity;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class OrderEntityBuilder {


    private UUID id;
    private String description;
    private UserEntity user;
    private BigDecimal total;
    private Instant createdAt;
    private Instant updatedAt;
    private Status status;
    private List<OrderItemEntity> itemEntities;


    public OrderEntityBuilder id(UUID id) {
        this.id = id;
        return this;
    }

    public OrderEntityBuilder description(String description) {
        this.description = description;
        return this;
    }

    public OrderEntityBuilder user(UserEntity user) {
        this.user = user;
        return this;
    }


    public OrderEntityBuilder total(BigDecimal total) {
        this.total = total;
        return this;
    }

    public OrderEntityBuilder createdAt(Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public OrderEntityBuilder updatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public OrderEntityBuilder status(Status status) {
        this.status = status;
        return this;
    }


    public OrderEntityBuilder items(List<OrderItemEntity> items) {
        this.itemEntities = items;
        return this;
    }


    public OrderEntity of() {
        return new OrderEntity(id, description, user, total, createdAt, updatedAt, status, itemEntities);
    }
}
