package br.com.camilaferreiranas.productservice.controllers;

import br.com.camilaferreiranas.productservice.model.dto.DefaultResponseDTO;
import br.com.camilaferreiranas.productservice.model.dto.ProductRequestDTO;
import br.com.camilaferreiranas.productservice.model.entities.Product;
import br.com.camilaferreiranas.productservice.model.enums.Category;
import br.com.camilaferreiranas.productservice.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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

    @GetMapping("/all")
    public ResponseEntity<Page<Product>> listAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                 @RequestParam(value = "size", defaultValue = "10") Integer size,
                                                 @RequestParam(value = "orderBy", defaultValue = "title") String orderBy,
                                                 @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        return ResponseEntity.ok(service.listAll(page, size, orderBy, direction));
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/findByCategory/{category}")
    public ResponseEntity<List<Product>> findByCategory(@PathVariable("category") Category category) {
        return ResponseEntity.ok(service.findByCategory(category));
    }

    @GetMapping("/findByTitle/{title}")
    public ResponseEntity<Product> findByTitle(@PathVariable("title") String title) {
        return ResponseEntity.ok(service.findByTitle(title));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<DefaultResponseDTO> update(@PathVariable("id") String id, @RequestBody ProductRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @PatchMapping("/changeQuantity/{id}/value/{quantity}")
    public ResponseEntity<Void> change(@PathVariable("quantity") Integer quantity, @PathVariable("id") String id) {
        service.changeQuantity(id,quantity);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find/{title}")
    public ResponseEntity<List<Product>> listTitles(@PathVariable("title") String title) {
        return ResponseEntity.ok(service.findByTitlePart(title));
    }
}
