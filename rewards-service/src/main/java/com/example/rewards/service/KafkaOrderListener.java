package com.example.rewards.service;

import com.example.rewards.model.OrderEvent;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashSet;
import java.util.Set;

/**
 * Kafka listener for order events. Processes events idempotently and confirms loyalty actions.
 */
@Service
public class KafkaOrderListener {
    private static final Logger logger = LoggerFactory.getLogger(KafkaOrderListener.class);
    private final ObjectMapper objectMapper = new ObjectMapper();
    // For demo: In-memory store for processed event IDs (replace with persistent store in production)
    private final Set<String> processedOrderIds = new HashSet<>();

    @KafkaListener(topics = "order-events", groupId = "rewards-service-group")
    public void listenOrderEvents(ConsumerRecord<String, String> record) {
        try {
            String message = record.value();
            OrderEvent event = objectMapper.readValue(message, OrderEvent.class);
            logger.info("Received order event: {}", message);
            // Idempotency check
            if (processedOrderIds.contains(event.getOrderId())) {
                logger.info("Order event already processed: orderId={}", event.getOrderId());
                return;
            }
            // Process loyalty actions (e.g., confirm points, update status)
            // ... (integration with Talon.One or internal logic)
            logger.info("Processed loyalty action for orderId={}, customerId={}", event.getOrderId(), event.getCustomerId());
            processedOrderIds.add(event.getOrderId());
        } catch (Exception e) {
            logger.error("Error processing order event: {}", record.value(), e);
        }
    }
}
