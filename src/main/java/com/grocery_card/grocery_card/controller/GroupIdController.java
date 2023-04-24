package com.grocery_card.grocery_card.controller;

import com.grocery_card.grocery_card.dto.UsersGroup;
import com.grocery_card.grocery_card.model.groupid.TheGroupId;
import com.grocery_card.grocery_card.model.groupid.TheGroupIdRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/group")
public class GroupIdController {
    BeanFactory context = new ClassPathXmlApplicationContext("applicationContext.xml");
    TheGroupIdRepository theGroupIdRepository = (TheGroupIdRepository) context.getBean("theGroupIdRepository");

    @GetMapping("/get_all/{id}")
    public List<UsersGroup> getAll(@PathVariable("id") Long id){
        return theGroupIdRepository.getAll(id);}


    @PostMapping("/save_user/{id}")
    public void save(@PathVariable("id") Long id, @Validated @RequestBody TheGroupId theGroupId){
        theGroupIdRepository.save(id, theGroupId);}

    @PutMapping("/delete_user/{id}")
    public void delete(@PathVariable("id") Long id, @Validated @RequestBody TheGroupId theGroupId){
        theGroupIdRepository.delete(id, theGroupId.getId());}
}
