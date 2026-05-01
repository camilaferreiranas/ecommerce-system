package br.com.camilaferreiranas.orderservice.domain.model;

import br.com.camilaferreiranas.orderservice.domain.enums.Status;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Order {
    private UUID id;
    private String description;
    private User user;
    private BigDecimal total;
    private Instant createdAt;
    private Instant updatedAt;
    private Status status;
    private List<OrderItem> orderItems;

    public Order() {
    }

    public Order(UUID id, String description, User user, BigDecimal total, Instant createdAt, Instant updatedAt, Status status, List<OrderItem> orderItems) {
        this.id = id;
        this.description = description;
        this.user = user;
        this.total = total;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
        this.orderItems = orderItems;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
