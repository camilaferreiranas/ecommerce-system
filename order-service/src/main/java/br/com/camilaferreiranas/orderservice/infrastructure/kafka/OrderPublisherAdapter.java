package br.com.camilaferreiranas.orderservice.infrastructure.kafka;

import br.com.camilaferreiranas.orderservice.infrastructure.dto.OrderCreatedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderPublisherAdapter implements OrderPublisher {


    private final KafkaTemplate<String, Object> kafkaTemplate;

    public OrderPublisherAdapter(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public <T extends OrderCreatedEvent> void sendMessage(T event) {
        kafkaTemplate.send("order-created", event.orderId(), event);
    }
}
