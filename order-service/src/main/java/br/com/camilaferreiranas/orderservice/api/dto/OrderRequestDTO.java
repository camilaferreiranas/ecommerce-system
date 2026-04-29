package br.com.camilaferreiranas.orderservice.api.dto;

import java.math.BigDecimal;

public record OrderRequestDTO(String description, BigDecimal total, UserRequestDTO  user) {

}
