package com.example.rewards.controller;

import com.example.rewards.model.RewardResponse;
import com.example.rewards.model.TalonOneSessionRequest;
import com.example.rewards.service.RewardsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/rewards")
@Tag(name = "Rewards API", description = "Endpoints for evaluating discounts and rewards")
public class RewardsController {

    private final RewardsService rewardsService;

    @Autowired
    public RewardsController(RewardsService rewardsService) {
        this.rewardsService = rewardsService;
    }

    @Operation(summary = "Evaluate cart for discounts and rewards",
            description = "Evaluates the provided cart data and returns applicable discounts and rewards.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Discounts and rewards returned",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = RewardResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid input data",
                            content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error",
                            content = @Content)
            })
    @PostMapping("/evaluate")
    public ResponseEntity<RewardResponse> evaluateCart(@Valid @RequestBody TalonOneSessionRequest request) {
        RewardResponse response = rewardsService.evaluateCart(request);
        return ResponseEntity.ok(response);
    }
}
