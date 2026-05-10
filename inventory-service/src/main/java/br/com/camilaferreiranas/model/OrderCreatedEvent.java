package br.com.camilaferreiranas.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public record OrderCreatedEvent(String orderId,
                                String description,
                                String status,
                                String userEmail,
                                List<OrderItemEvent> items,
                                Instant createdAt) {

    public record OrderItemEvent(String productId, int quantity, BigDecimal price) {}
}
