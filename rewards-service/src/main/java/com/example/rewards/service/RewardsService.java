package com.example.rewards.service;

import com.example.rewards.model.RewardResponse;
import com.example.rewards.model.TalonOneSessionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for evaluating cart data and managing rewards.
 */
@Service
public class RewardsService {
    private final TalonOneService talonOneService;

    @Autowired
    public RewardsService(TalonOneService talonOneService) {
        this.talonOneService = talonOneService;
    }

    /**
     * Evaluates the provided cart data using Talon.One API and returns discounts and rewards.
     */
    public RewardResponse evaluateCart(TalonOneSessionRequest request) {
        // Additional business logic can be added here if needed
        return talonOneService.evaluateSession(request);
    }
}
