package br.com.camilaferreiranas.orderservice.infrastructure.kafka;

import br.com.camilaferreiranas.orderservice.infrastructure.dto.OrderCreatedEvent;

public interface OrderPublisher {

    <T extends OrderCreatedEvent> void  sendMessage(T event);
}
