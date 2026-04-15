package br.com.camilaferreiranas.productservice.model.dto;

import br.com.camilaferreiranas.productservice.model.enums.Category;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ProductRequestDTO(@NotBlank(message = "Title can not be empty") String title,
                                String description,
                                Category category,
                                @Min(value = 1, message = "Quantity must be greater than 1") Integer quantity) {
}
