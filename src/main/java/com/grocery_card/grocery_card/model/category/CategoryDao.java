package com.grocery_card.grocery_card.model.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryDao {
    @Autowired
    private CategoryRepository repository;

    public void save(Category category){
        repository.save(category);}

    public Long getCountCategory(){
        return repository.count();}

    public List<Category> getAllCategories(){
        List<Category> categories = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(categories::add);
        return categories;}

    public Category getCategoryById(Integer id){
        return repository.findById(id).orElse(null);}

    public void delete(Category category){
        repository.delete(category);
    }
}
