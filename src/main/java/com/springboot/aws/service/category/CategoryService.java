package com.springboot.aws.service.category;

import com.springboot.aws.domain.aws.MessageAwsDTO;
import com.springboot.aws.domain.category.Category;
import com.springboot.aws.domain.category.CategoryDTO;
import com.springboot.aws.domain.category.CategoryNotFoundException;
import com.springboot.aws.repository.category.CategoryRepository;
import com.springboot.aws.service.aws.AwsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final AwsService awsService;

    public CategoryService(CategoryRepository categoryRepository, AwsService awsService){
        this.categoryRepository = categoryRepository;
        this.awsService=awsService;
    }

    public Category createCategory(CategoryDTO categoryDTO){
        Category newCategory = new Category(categoryDTO);
        this.categoryRepository.save(newCategory);
        this.awsService.publishMessage(new MessageAwsDTO(newCategory.toString()));
        return newCategory;
    }

    public List<Category> getCategory(){
       return this.categoryRepository.findAll();
    }

    public Category updateCategory(String id, CategoryDTO categoryDTO){
        Category newCategory = this.categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);

        if(!categoryDTO.titleName().isEmpty()) newCategory.setTitleName(categoryDTO.titleName());
        if(!categoryDTO.description().isEmpty()) newCategory.setDescription(categoryDTO.description());
        if(!categoryDTO.ownerId().isEmpty()) newCategory.setOwnerId(categoryDTO.ownerId());

        this.categoryRepository.save(newCategory);

        this.awsService.publishMessage(new MessageAwsDTO(newCategory.toString()));
        return newCategory;
    }

    public void deleteRoom(String id){
        Category categoryDeleted = this.categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
        this.awsService.publishMessage(new MessageAwsDTO(categoryDeleted.deleteToString()));
        this.categoryRepository.delete(categoryDeleted);
    }

    public Category getById(String id){
        return this.categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
    }

}
