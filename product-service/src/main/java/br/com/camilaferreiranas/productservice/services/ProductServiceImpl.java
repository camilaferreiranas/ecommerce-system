package br.com.camilaferreiranas.productservice.services;

import br.com.camilaferreiranas.productservice.model.dto.DefaultResponseDTO;
import br.com.camilaferreiranas.productservice.model.dto.ProductRequestDTO;
import br.com.camilaferreiranas.productservice.model.entities.Product;
import br.com.camilaferreiranas.productservice.model.enums.Category;
import br.com.camilaferreiranas.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{



    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }


    @Override
    public DefaultResponseDTO save(ProductRequestDTO dto) {
        Product product = new Product();
        product.setTitle(dto.title());
        product.setDescription(dto.description());
        product.setCategory(dto.category());
        product.setQuantity(dto.quantity());
        var response = repository.save(product);
        return new DefaultResponseDTO(response.getId(), "Produto cadastrado com sucesso") ;
    }

    @Override
    public List<Product> listAll() {
        return List.of();
    }

    @Override
    public Product findById(String id) {
        return null;
    }

    @Override
    public Product findByCategory(Category category) {
        return null;
    }

    @Override
    public Product findByTitle(String title) {
        return null;
    }

    @Override
    public DefaultResponseDTO update(String id, ProductRequestDTO dto) {
        return null;
    }

    @Override
    public void changeQuantity(String id, Integer quantity) {

    }
}
