package br.com.camilaferreiranas.productservice.model.entities;

import br.com.camilaferreiranas.productservice.model.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private String id;

    @Field(value = "title")
    private String title;

    @Field(value = "description")
    private String description;


    private Category category;

    @Field(value = "quantity")
    private Integer quantity;

}
