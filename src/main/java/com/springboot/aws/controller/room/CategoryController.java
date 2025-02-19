package com.springboot.aws.controller.room;


import com.springboot.aws.domain.category.Category;
import com.springboot.aws.domain.category.CategoryDTO;
import com.springboot.aws.service.room.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Category> createRoom(@RequestBody CategoryDTO categoryData){
        Category newCategory = this.categoryService.createCategory(categoryData);
        return ResponseEntity.ok().body(newCategory);

    }

    @GetMapping
    public ResponseEntity<List<Category>> getRoom(){
        List<Category> listCategory = this.categoryService.getCategory();
        return ResponseEntity.ok().body(listCategory);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateRoom(@PathVariable("id") String id, @RequestBody CategoryDTO categoryData){
        return ResponseEntity.ok().body(this.categoryService.updateCategory(id, categoryData));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteRoom(@PathVariable("id") String id){
        this.categoryService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getByIdRoom(@PathVariable("id") String id){
        return ResponseEntity.ok().body(this.categoryService.getById(id));
    }
}
