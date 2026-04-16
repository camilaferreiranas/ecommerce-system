package br.com.camilaferreiranas.productservice.services;

import br.com.camilaferreiranas.productservice.model.dto.DefaultResponseDTO;
import br.com.camilaferreiranas.productservice.model.dto.ProductRequestDTO;
import br.com.camilaferreiranas.productservice.model.entities.Product;
import br.com.camilaferreiranas.productservice.model.enums.Category;
import br.com.camilaferreiranas.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        product.setPrice(dto.price());
        var response = repository.save(product);
        return new DefaultResponseDTO(response.getId(), "Produto cadastrado com sucesso") ;
    }

    @Override
    public List<Product> listAll() {
       return repository.findAll();
    }

    @Override
    public Product findById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return repository.findByCategory(category);
    }

    @Override
    public Product findByTitle(String title) {
        return repository.findByTitle(title).orElseThrow(() -> new RuntimeException("Title not found "));
    }

    @Override
    public DefaultResponseDTO update(String id, ProductRequestDTO dto) {
        Product entityToSave = repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        entityToSave.setPrice(dto.price());
        entityToSave.setTitle(dto.title());
        entityToSave.setCategory(dto.category());
        entityToSave.setTitle(dto.title());
        entityToSave.setDescription(dto.description());

        var response = repository.save(entityToSave);
        return new DefaultResponseDTO(response.getId(), "Product was updated");
    }

    @Override
    public void changeQuantity(String id, Integer quantity) {
        Product entityToSave = repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        if(quantity < 0 ) {
            throw new RuntimeException("Quantity can not be less than zero");
        }
        entityToSave.setQuantity(quantity);
        repository.save(entityToSave);
    }

    @Override
    public List<Product> findByTitlePart(String title) {
        return  repository.findByTitlePart(title);
    }
}
