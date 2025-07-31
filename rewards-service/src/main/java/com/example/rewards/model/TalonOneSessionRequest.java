package com.example.rewards.model;

import java.util.List;

/**
 * Model representing the request payload for Talon.One session evaluation.
 */
public class TalonOneSessionRequest {
    private String customerId;
    private List<CartItem> cartItems;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    /**
     * Inner class representing a cart item.
     */
    public static class CartItem {
        private String productId;
        private int quantity;
        private double price;

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
