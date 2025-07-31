package com.example.userservice.talonone;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Component
public class TalonOneClient {
    @Value("${talonone.api-key}")
    private String apiKey;

    @Value("${talonone.base-url}")
    private String baseUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public void registerUserInTalonOne(String email, String firstName, String lastName) {
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/v1/customers")
                .toUriString();

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("integrationId", email);
        requestBody.put("attributes", Map.of(
                "firstName", firstName,
                "lastName", lastName
        ));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "ApiKey " + apiKey);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    url,
                    HttpMethod.PUT,
                    entity,
                    String.class
            );
            if (!response.getStatusCode().is2xxSuccessful()) {
                throw new RuntimeException("Failed to register user in Talon.One: " + response.getStatusCode());
            }
        } catch (Exception e) {
            throw new RuntimeException("Talon.One registration failed: " + e.getMessage(), e);
        }
    }
}
