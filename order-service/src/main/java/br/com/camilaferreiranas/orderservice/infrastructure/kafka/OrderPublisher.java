package br.com.camilaferreiranas.orderservice.infrastructure.kafka;

public interface OrderPublisher {

    void sendMessage(String topic, String message);
}
