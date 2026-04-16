package br.com.camilaferreiranas.productservice.services;

import br.com.camilaferreiranas.productservice.model.dto.InventoryResponse;
import br.com.camilaferreiranas.productservice.repositories.ProductRepository;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final ProductRepository repository;

    public InventoryServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }


    @Override
    public InventoryResponse info() {
        return repository.inventoryTotalPrice();
     }
}
