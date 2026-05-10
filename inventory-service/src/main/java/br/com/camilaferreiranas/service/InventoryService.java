package br.com.camilaferreiranas.service;


import br.com.camilaferreiranas.model.OrderCreatedEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class InventoryService {


    @Inject
    @RestClient
    ProductService productService;



    public void checkInventory(OrderCreatedEvent event) {
        var items = event.items();
    }
}
