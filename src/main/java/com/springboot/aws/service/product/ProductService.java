package com.springboot.aws.service.product;

import com.springboot.aws.domain.aws.MessageAwsDTO;
import com.springboot.aws.domain.category.Category;
import com.springboot.aws.domain.product.Product;
import com.springboot.aws.domain.product.ProductDTO;
import com.springboot.aws.domain.product.ProductNotFoundException;
import com.springboot.aws.repository.product.ProductRepository;
import com.springboot.aws.service.aws.AwsService;
import com.springboot.aws.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final CategoryService categoryService;
    private final ProductRepository productRepository;
    private final AwsService awsService;

    public Product createProduct(ProductDTO productDTO){
        Product newProduct = new Product(productDTO);

        if(productDTO.category() != null){
            Category category = this.categoryService.getById(productDTO.category());
            newProduct.setCategory(category.getId());
        }
        this.productRepository.save(newProduct);

        this.awsService.publishMessage(new MessageAwsDTO(newProduct.toString()));
        return newProduct;
    }

    public List<Product> getProduct(){
        return this.productRepository.findAll();
    }

    public Product updateProduct(String id, ProductDTO productDTO){

        Product newProduct = this.productRepository.findById(id).orElseThrow(ProductNotFoundException::new);

        if(!productDTO.titleName().isEmpty()) newProduct.setTitleName(productDTO.titleName());
        if(productDTO.description().isEmpty()) newProduct.setCategory(productDTO.description());
        if(!productDTO.ownerId().isEmpty()) newProduct.setOwnerId(productDTO.ownerId());
        if(!(productDTO.price() == null)) newProduct.setPrice(productDTO.price());

        if(productDTO.category() != null){
            Category category = this.categoryService.getById(productDTO.category());
            newProduct.setCategory(category.getId());
        }

        this.productRepository.save(newProduct);

        this.awsService.publishMessage(new MessageAwsDTO(newProduct.toString()));

        return newProduct;
    }

    public void deleteProduct(String id){
        Product productDeleted = this.productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        this.productRepository.delete(productDeleted);
        this.awsService.publishMessage(new MessageAwsDTO(productDeleted.deleteToString()));
    }

    public Product getByIdProduct(String id){
        return this.productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }
}
