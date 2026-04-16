package br.com.camilaferreiranas.productservice.controllers;

import br.com.camilaferreiranas.productservice.model.dto.InventoryResponse;
import br.com.camilaferreiranas.productservice.services.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {


    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }


    @GetMapping("/info")
    public ResponseEntity<InventoryResponse> info() {
        return ResponseEntity.ok(service.info());
    }
}
