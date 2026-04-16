package br.com.camilaferreiranas.productservice.model.dto;

import java.math.BigDecimal;

public record InventoryResponse(Integer quantity, BigDecimal totalPrice) {
}
