package com.example.rewards.model;

import java.util.List;

/**
 * Model representing the response for evaluated discounts and rewards.
 */
public class RewardResponse {
    private List<String> discounts;
    private List<String> rewards;
    private String message;

    public RewardResponse() {
    }

    public RewardResponse(List<String> discounts, List<String> rewards, String message) {
        this.discounts = discounts;
        this.rewards = rewards;
        this.message = message;
    }

    public List<String> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<String> discounts) {
        this.discounts = discounts;
    }

    public List<String> getRewards() {
        return rewards;
    }

    public void setRewards(List<String> rewards) {
        this.rewards = rewards;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
