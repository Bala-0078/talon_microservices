package com.example.orderservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class OrderRequest {
    @NotNull
    private Long userId;
    @NotEmpty
    private List<CartItemDto> cartItems;
    @NotNull
    private Double totalAmount;

    public OrderRequest() {}

    public OrderRequest(Long userId, List<CartItemDto> cartItems, Double totalAmount) {
        this.userId = userId;
        this.cartItems = cartItems;
        this.totalAmount = totalAmount;
    }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public List<CartItemDto> getCartItems() { return cartItems; }
    public void setCartItems(List<CartItemDto> cartItems) { this.cartItems = cartItems; }
    public Double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }
}
