package com.example.orderservice.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public class OrderResponse {
    private Long orderId;
    private Long userId;
    private List<CartItemDto> cartItems;
    private BigDecimal totalAmount;
    private BigDecimal discount;
    private Instant createdAt;

    public OrderResponse() {}

    public OrderResponse(Long orderId, Long userId, List<CartItemDto> cartItems, BigDecimal totalAmount, BigDecimal discount, Instant createdAt) {
        this.orderId = orderId;
        this.userId = userId;
        this.cartItems = cartItems;
        this.totalAmount = totalAmount;
        this.discount = discount;
        this.createdAt = createdAt;
    }

    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public List<CartItemDto> getCartItems() { return cartItems; }
    public void setCartItems(List<CartItemDto> cartItems) { this.cartItems = cartItems; }
    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }
    public BigDecimal getDiscount() { return discount; }
    public void setDiscount(BigDecimal discount) { this.discount = discount; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
