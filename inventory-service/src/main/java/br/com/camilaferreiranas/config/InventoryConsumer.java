package br.com.camilaferreiranas.config;

import br.com.camilaferreiranas.model.OrderCreatedEvent;
import br.com.camilaferreiranas.service.InventoryService;
import org.eclipse.microprofile.reactive.messaging.Incoming;

public class InventoryConsumer {


    private final InventoryService inventoryService;

    public InventoryConsumer(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @Incoming("order-status")
    public void consume(OrderCreatedEvent event) {

        inventoryService.checkInventory(event);
    }
}
