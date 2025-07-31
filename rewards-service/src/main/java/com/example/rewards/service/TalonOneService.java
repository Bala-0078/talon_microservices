package com.example.rewards.service;

import com.example.rewards.exception.TalonOneException;
import com.example.rewards.model.RewardResponse;
import com.example.rewards.model.TalonOneSessionRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
public class TalonOneService {
    private static final Logger logger = LoggerFactory.getLogger(TalonOneService.class);

    private final WebClient talonOneWebClient;

    @Value("${talonone.api.session-endpoint:/v1/customer_sessions}")
    private String sessionEndpoint;

    @Autowired
    public TalonOneService(WebClient talonOneWebClient) {
        this.talonOneWebClient = talonOneWebClient;
    }

    /**
     * Calls Talon.One API to evaluate the cart and return discounts and rewards.
     */
    public RewardResponse evaluateSession(TalonOneSessionRequest request) {
        try {
            // POST to Talon.One session endpoint
            RewardResponse response = talonOneWebClient.post()
                    .uri(sessionEndpoint)
                    .body(Mono.just(request), TalonOneSessionRequest.class)
                    .retrieve()
                    .bodyToMono(RewardResponse.class)
                    .block();
            logger.info("Talon.One session evaluated successfully for customerId={}", request.getCustomerId());
            return response;
        } catch (WebClientResponseException e) {
            logger.error("Talon.One API error: status={}, body={}", e.getRawStatusCode(), e.getResponseBodyAsString());
            throw new TalonOneException("Talon.One API error: " + e.getMessage(), e);
        } catch (Exception e) {
            logger.error("Unexpected error calling Talon.One API", e);
            throw new TalonOneException("Unexpected error calling Talon.One API", e);
        }
    }
}
