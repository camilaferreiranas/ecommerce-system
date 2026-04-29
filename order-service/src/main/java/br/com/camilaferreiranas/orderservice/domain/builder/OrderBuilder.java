package br.com.camilaferreiranas.orderservice.domain.builder;

import br.com.camilaferreiranas.orderservice.domain.enums.Status;
import br.com.camilaferreiranas.orderservice.domain.model.Order;
import br.com.camilaferreiranas.orderservice.domain.model.User;
import br.com.camilaferreiranas.orderservice.infrastructure.builder.OrderEntityBuilder;
import br.com.camilaferreiranas.orderservice.infrastructure.persistence.jpa.entities.UserEntity;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class OrderBuilder {


    private UUID id;
    private String description;
    private User user;
    private BigDecimal total;
    private Instant createdAt;
    private Instant updatedAt;
    private Status status;


    public OrderBuilder id(UUID id) {
        this.id = id;
        return this;
    }

    public OrderBuilder description(String description) {
        this.description = description;
        return this;
    }

    public OrderBuilder user(User user) {
        this.user = user;
        return this;
    }


    public OrderBuilder total(BigDecimal total) {
        this.total = total;
        return this;
    }

    public OrderBuilder createdAt(Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public OrderBuilder updatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public OrderBuilder status(Status status) {
        this.status = status;
        return this;
    }


    public Order of() {
        return new Order(id, description, user, total, createdAt, updatedAt, status);
    }
}
