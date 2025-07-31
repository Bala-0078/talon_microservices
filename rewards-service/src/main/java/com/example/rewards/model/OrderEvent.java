package com.example.rewards.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model representing an order event consumed from Kafka.
 */
public class OrderEvent {
    @JsonProperty("orderId")
    private String orderId;

    @JsonProperty("customerId")
    private String customerId;

    @JsonProperty("totalAmount")
    private double totalAmount;

    // Add other relevant fields as needed

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
