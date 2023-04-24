package com.grocery_card.grocery_card.controller;

import com.grocery_card.grocery_card.dto.HistoryTarget;
import com.grocery_card.grocery_card.model.target.Target;
import com.grocery_card.grocery_card.dto.ProductTarget;
import com.grocery_card.grocery_card.model.target.TargetRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/target")
public class TargetController {
    BeanFactory context = new ClassPathXmlApplicationContext("applicationContext.xml");
    TargetRepository targetRepository = (TargetRepository) context.getBean("targetRepository");
    @GetMapping("/get_all_active/{id}")
    public List<ProductTarget> getAllProduct(@PathVariable("id") Long id){
        return targetRepository.getAllActive(id);}

    @GetMapping("/get_all_history/{id}")
    public List<HistoryTarget> getAllHistory(@PathVariable("id") Long id){
        return targetRepository.getAllHistory(id);}

    @PostMapping("/save_product/{id}")
    public int save(@PathVariable("id") Long id, @Validated @RequestBody Target target){
        return targetRepository.save(id, target);}

    @PutMapping("/update_product/{id}")
    public void updateProduct(@PathVariable("id") Long id, @Validated @RequestBody Target target){
        targetRepository.updateStatus(id, target);}

    @PutMapping("/delete_product/{id}")
    public void deleteProduct(@PathVariable("id") Long id, @Validated @RequestBody Target target){
        targetRepository.delete(id, target.getId_product());}
}
