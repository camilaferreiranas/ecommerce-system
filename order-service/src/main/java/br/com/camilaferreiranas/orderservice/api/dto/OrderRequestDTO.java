package br.com.camilaferreiranas.orderservice.api.dto;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequestDTO(String description, UserRequestDTO  user, List<OrderItemDTO> items) {

}
