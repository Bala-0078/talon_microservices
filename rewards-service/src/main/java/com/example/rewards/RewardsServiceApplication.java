package com.example.rewards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the Rewards Service Spring Boot application.
 * This service evaluates discounts and manages customer rewards by integrating with Talon.One API.
 */
@SpringBootApplication
public class RewardsServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RewardsServiceApplication.class, args);
    }
}
