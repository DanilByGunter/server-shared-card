package com.grocery_card.grocery_card.controller;

import com.grocery_card.grocery_card.model.category.Category;
import com.grocery_card.grocery_card.model.category.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryDao categoryDao;
    @GetMapping("/get_all")
    public List<Category> getAllCategories(){
        return categoryDao.getAllCategories();}
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable("id") Integer id) {
        return categoryDao.getCategoryById(id);}
    @PostMapping("/save")
    public void save(@RequestBody Category category){
        categoryDao.save(category);}

}
