package com.springboot.aws.controller.studient;

import com.springboot.aws.domain.product.Product;
import com.springboot.aws.domain.product.ProductDTO;
import com.springboot.aws.service.product.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createStudient(@RequestBody ProductDTO roomData){
        Product newProduct = this.productService.createProduct(roomData);
        return ResponseEntity.ok().body(newProduct);

    }

    @GetMapping
    public ResponseEntity<List<Product>> geStudient(){
        List<Product> listRoom = this.productService.getProduct();
        return ResponseEntity.ok().body(listRoom);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getByIdStudient(@PathVariable("id") String id){
        return ResponseEntity.ok().body(this.productService.getByIdProduct(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Product> updateStudient(@PathVariable("id") String id, @RequestBody ProductDTO studientData){
        return ResponseEntity.ok().body(this.productService.updateProduct(id, studientData));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteStudient(@PathVariable("id") String id){
        this.productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
