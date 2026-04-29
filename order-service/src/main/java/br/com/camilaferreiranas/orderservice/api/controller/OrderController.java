package br.com.camilaferreiranas.orderservice.api.controller;


import br.com.camilaferreiranas.orderservice.api.dto.DefaultResponseDTO;
import br.com.camilaferreiranas.orderservice.api.dto.OrderRequestDTO;
import br.com.camilaferreiranas.orderservice.application.usecases.orders.CreateOrderUseCase;
import br.com.camilaferreiranas.orderservice.application.usecases.orders.ListOrdersUseCase;
import br.com.camilaferreiranas.orderservice.domain.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/order")
public class OrderController {



    private final CreateOrderUseCase createOrderUseCase;
    private final ListOrdersUseCase listOrdersUseCase;

    public OrderController(CreateOrderUseCase createOrderUseCase, ListOrdersUseCase listOrdersUseCase) {
        this.createOrderUseCase = createOrderUseCase;
        this.listOrdersUseCase = listOrdersUseCase;
    }


    @PostMapping("/create")
    public ResponseEntity<DefaultResponseDTO> save(@RequestBody OrderRequestDTO dto) {
        return ResponseEntity.ok(createOrderUseCase.execute(dto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Order>> listAll() {
        return ResponseEntity.ok(listOrdersUseCase.execute());
    }
}
