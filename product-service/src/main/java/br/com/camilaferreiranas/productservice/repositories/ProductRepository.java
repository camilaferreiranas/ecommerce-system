package br.com.camilaferreiranas.productservice.repositories;

import br.com.camilaferreiranas.productservice.model.dto.InventoryResponse;
import br.com.camilaferreiranas.productservice.model.entities.Product;
import br.com.camilaferreiranas.productservice.model.enums.Category;
import feign.Param;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {


    List<Product> findByCategory(Category category);
    Optional<Product> findByTitle(String title);

    @Query("{ 'title': { $regex: ?0, $options: 'i' } } ")
    List<Product> findByTitlePart(String titlePart);

    @Aggregation(
           pipeline = {
                   """
                    { $group: { _id: null,
                                quantity : { $sum: '$quantity'},
                                totalPrice: { $sum: { $multiply: ['$quantity', '$price' ] } }
                                } }"""
    } )
    InventoryResponse inventoryTotalPrice();




}
