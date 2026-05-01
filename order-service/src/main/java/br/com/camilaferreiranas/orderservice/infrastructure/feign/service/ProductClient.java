package br.com.camilaferreiranas.orderservice.infrastructure.feign.service;


import br.com.camilaferreiranas.orderservice.infrastructure.feign.dto.Product;

import br.com.camilaferreiranas.orderservice.infrastructure.feign.dto.ProductItemDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "product", url = "http://localhost:8081/products")
public interface ProductClient {



    @GetMapping("/all")
     Page<Product> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                 @RequestParam(value = "size", defaultValue = "10") Integer size,
                                                 @RequestParam(value = "orderBy", defaultValue = "title") String orderBy,
                                                 @RequestParam(value = "direction", defaultValue = "ASC") String direction);

    @GetMapping("/findByTitle/{title}")
     Product findByTitle(@PathVariable ("title") String title);


    @PostMapping("/findBatch")
    List<Product> findByBatch(@RequestBody List<ProductItemDTO> items );
}
