package com.springboot.aws.domain.product;

import com.springboot.aws.domain.category.Category;
import lombok.*;
import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Document(collection = "product")
public class Product {

    @Id
    private String id;
    private String titleName;
    private String ownerId;
    private String description;
    private Integer price;
    private String category;

    public Product(ProductDTO productDTO){
        this.titleName=productDTO.titleName();
        this.ownerId=productDTO.ownerId();
        this.description=productDTO.description();
        this.price=productDTO.price();
        this.category=productDTO.category();
    }


}
