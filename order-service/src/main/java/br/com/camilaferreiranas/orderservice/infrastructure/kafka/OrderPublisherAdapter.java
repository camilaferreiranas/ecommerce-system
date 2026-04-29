package br.com.camilaferreiranas.orderservice.infrastructure.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderPublisherAdapter implements OrderPublisher {


    private final KafkaTemplate<String, String> kafkaTemplate;

    public OrderPublisherAdapter(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }
}
