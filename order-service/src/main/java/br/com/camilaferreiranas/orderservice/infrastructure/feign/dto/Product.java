package br.com.camilaferreiranas.orderservice.infrastructure.feign.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;


@Data
public class Product {



    private String id;


    private String title;


    private String description;



    private String imageUrl;


    private Category category;


    private Integer quantity;

    private BigDecimal price;

}
