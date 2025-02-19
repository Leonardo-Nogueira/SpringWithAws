package com.springboot.aws.domain.product;

import com.springboot.aws.domain.category.Category;

public record ProductDTO(String titleName,
                         String ownerId,
                         String description,
                         Integer price,
                         String category) {
}
