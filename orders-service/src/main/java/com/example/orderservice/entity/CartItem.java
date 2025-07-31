package com.example.orderservice.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CartItem implements Serializable {
    private Long productId;
    private Integer quantity;

    public CartItem() {}

    public CartItem(Long productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
