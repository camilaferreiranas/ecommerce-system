package br.com.camilaferreiranas.orderservice.domain.model;

import br.com.camilaferreiranas.orderservice.domain.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Order {
    private UUID id;
    private String description;
    private User user;
    private BigDecimal total;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Status status;

}
