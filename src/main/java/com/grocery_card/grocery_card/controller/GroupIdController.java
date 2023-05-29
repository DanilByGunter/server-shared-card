package com.grocery_card.grocery_card.controller;

import com.grocery_card.grocery_card.dto.UsersGroup;
import com.grocery_card.grocery_card.model.groupid.TheGroupId;
import com.grocery_card.grocery_card.model.groupid.TheGroupIdRepository;
import com.grocery_card.grocery_card.model.theallgroup.TheAllGroup;
import com.grocery_card.grocery_card.model.theallgroup.TheAllGroupDao;
import com.grocery_card.grocery_card.dto.TheAllGroupWithUsers;
import com.grocery_card.grocery_card.dto.UserWithGroup;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import java.util.List;

@Validated
@RestController
@RequestMapping("/group")
public class GroupIdController {
    BeanFactory context = new ClassPathXmlApplicationContext("applicationContext.xml");
    TheGroupIdRepository theGroupIdRepository = (TheGroupIdRepository) context.getBean("theGroupIdRepository");
    @Autowired
    private TheAllGroupDao theAllGroupDao;


    @GetMapping("/get_all/{id}")
    public List<UsersGroup> getAll(@PathVariable("id") Long id){
        List<UsersGroup> users = theGroupIdRepository.getAll(id);
        return users;
    }


    @PostMapping("/save_user")
    public Boolean save(@Validated @RequestBody UserWithGroup userWithGroup){
        TheAllGroup group = theAllGroupDao.getGroupById(userWithGroup.getIdGroup());
        if(group!=null && group.getName().equals(userWithGroup.getNameGroup())) {
            theGroupIdRepository.save(group.getId(), userWithGroup.getUser());
            return true;
        }
        else{
            return false;
        }
    }

    @PutMapping("/delete_user/{id}")
    public void delete(@PathVariable("id") Long id, @Validated @RequestBody TheGroupId theGroupId){
        theGroupIdRepository.delete(id, theGroupId.getId());
    }
}
