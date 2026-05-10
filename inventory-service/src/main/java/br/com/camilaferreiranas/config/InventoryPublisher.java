package br.com.camilaferreiranas.config;

import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

public class InventoryPublisher {

    @Inject
    @Channel("inventory")
    Emitter<String> emitter;


    public void send(String message) {
        emitter.send(message);
    }
}
