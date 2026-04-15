package br.com.camilaferreiranas.productservice.controllers;

import br.com.camilaferreiranas.productservice.model.dto.DefaultResponseDTO;
import br.com.camilaferreiranas.productservice.model.dto.ProductRequestDTO;
import br.com.camilaferreiranas.productservice.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(path = "/products")
public class ProductController {


    private final ProductService service;


    public ProductController(ProductService service) {
        this.service = service;
    }


    @PostMapping("/save")
    public ResponseEntity<DefaultResponseDTO> save(@Valid @RequestBody ProductRequestDTO dto) {
        var response = service.save(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id")
                .buildAndExpand(response.id())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }
}
