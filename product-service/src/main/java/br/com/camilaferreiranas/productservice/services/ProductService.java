package br.com.camilaferreiranas.productservice.services;

import br.com.camilaferreiranas.productservice.model.dto.DefaultResponseDTO;
import br.com.camilaferreiranas.productservice.model.dto.ProductRequestDTO;
import br.com.camilaferreiranas.productservice.model.entities.Product;
import br.com.camilaferreiranas.productservice.model.enums.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    DefaultResponseDTO save(ProductRequestDTO dto);
    Page<Product> listAll(Integer page, Integer size, String orderBy, String direction);
    Product findById(String id);
    List<Product> findByCategory(Category category);
    Product findByTitle(String title);
    DefaultResponseDTO update(String id, ProductRequestDTO dto);
    void changeQuantity(String id, Integer quantity);
    List<Product> findByTitlePart(String title);
}
