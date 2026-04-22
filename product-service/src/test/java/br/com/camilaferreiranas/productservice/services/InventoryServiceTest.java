package br.com.camilaferreiranas.productservice.services;


import br.com.camilaferreiranas.productservice.model.dto.InventoryResponse;
import br.com.camilaferreiranas.productservice.repositories.ProductRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InventoryServiceTest {


    @Mock
    private ProductRepository repository;


    @InjectMocks
    private InventoryServiceImpl service;

    Faker faker;

    @BeforeEach
    void setUp() {
        faker = new Faker();
    }

    @Test
    public void shouldReturnInventoryResponse() {
        when(repository.inventoryTotalPrice()).thenReturn(new InventoryResponse(faker.number().randomDigit(),
                BigDecimal.ONE));
        InventoryResponse response = service.info();
        assertNotNull(response);
        verify(repository, times(1)).inventoryTotalPrice();

    }
}
