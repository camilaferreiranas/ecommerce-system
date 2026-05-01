package br.com.camilaferreiranas.orderservice.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderItem {

    private Integer id;
    private String productId;
    private Integer quantity;
    private BigDecimal price;


    public OrderItem() {
    }


    public OrderItem(Integer id, String productId, Integer quantity, BigDecimal price) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
