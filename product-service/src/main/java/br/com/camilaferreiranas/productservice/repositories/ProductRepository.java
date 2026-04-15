package br.com.camilaferreiranas.productservice.repositories;

import br.com.camilaferreiranas.productservice.model.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
