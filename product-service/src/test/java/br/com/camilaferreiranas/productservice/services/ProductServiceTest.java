package br.com.camilaferreiranas.productservice.services;

import br.com.camilaferreiranas.productservice.exception.ProductNotFoundException;
import br.com.camilaferreiranas.productservice.model.dto.DefaultResponseDTO;
import br.com.camilaferreiranas.productservice.model.dto.ProductRequestDTO;
import br.com.camilaferreiranas.productservice.model.entities.Product;
import br.com.camilaferreiranas.productservice.model.enums.Category;
import br.com.camilaferreiranas.productservice.repositories.ProductRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductServiceImpl service;


    Faker faker;


    @BeforeEach
    void setUp() {
        faker = new Faker();
    }


    @Test
    void shouldReturnProductWhenTitleExist() {

        String title = faker.book().title();
        when(repository.findByTitle(title)).thenReturn(Optional.of(
                new Product("8172971", faker.chuckNorris().fact(), faker.chuckNorris().fact(),
                        Category.BOOKS, faker.number().randomDigit(), BigDecimal.ONE)));

        Product response = service.findByTitle(title);
        assertNotNull(response);
        verify(repository, times(1)).findByTitle(title);
    }


    @Test
    void shouldThrowProductNotFoundExceptionWhenTitleDontExist() {
        String title = faker.book().title();
        when(repository.findByTitle(title)).thenReturn(Optional.empty());

        assertThrows(ProductNotFoundException.class, () -> service.findByTitle(title));
        verify(repository).findByTitle(title);
    }


    @Test
    void shouldSaveProduct() {
        var product = new ProductRequestDTO(faker.harryPotter().book(),
                faker.hacker().abbreviation(), Category.BOOKS, 1, BigDecimal.ONE);
        var productEntity = new Product("8172971", faker.chuckNorris().fact(), faker.hacker().abbreviation(),
                Category.ELECTRONICS, 1, BigDecimal.ONE);


        when(repository.save(any(Product.class))).thenReturn(productEntity);
        DefaultResponseDTO response = service.save(product);

        assertNotNull(response);
        verify(repository, times(1)).save(any(Product.class));


    }
}