package com.grocery_card.grocery_card.controller;

import com.grocery_card.grocery_card.dto.HistoryCheck;
import com.grocery_card.grocery_card.dto.ProductCheck;
import com.grocery_card.grocery_card.model.check.Check;
import com.grocery_card.grocery_card.model.check.CheckRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/check")
public class CheckController {
    BeanFactory context = new ClassPathXmlApplicationContext("applicationContext.xml");
    CheckRepository checkRepository = (CheckRepository) context.getBean("checkRepository");
    @GetMapping("/get_all_active/{id}")
    public List<ProductCheck> getAllProduct(@PathVariable("id") Long id){
        return checkRepository.getAllActive(id);}

    @GetMapping("/get_all_history/{id}")
    public List<HistoryCheck> getAllHistory(@PathVariable("id") Long id){
        return checkRepository.getAllHistory(id);}

    @PostMapping("/save_product/{id}")
    public int save(@PathVariable("id") Long id, @Validated @RequestBody Check check){
        return checkRepository.save(id, check);}

    @PutMapping("/update_product/{id}")
    public void updateProduct(@PathVariable("id") Long id, @Validated @RequestBody Check check){
        checkRepository.updateStatus(id, check);}

    @PutMapping("/delete_product/{id}")
    public void deleteProduct(@PathVariable("id") Long id, @Validated @RequestBody Check check){
        checkRepository.delete(id, check.getId_product());}
}
