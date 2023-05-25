package com.grocery_card.grocery_card.controller;

import com.grocery_card.grocery_card.model.groupid.TheGroupId;
import com.grocery_card.grocery_card.model.groupid.TheGroupIdRepository;
import com.grocery_card.grocery_card.model.theallgroup.TheAllGroupDao;
import com.grocery_card.grocery_card.dto.TheAllGroupWithUsers;
import com.grocery_card.grocery_card.dto.UserWithGroup;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/group")
public class GroupIdController {
    BeanFactory context = new ClassPathXmlApplicationContext("applicationContext.xml");
    TheGroupIdRepository theGroupIdRepository = (TheGroupIdRepository) context.getBean("theGroupIdRepository");
    @Autowired
    private TheAllGroupDao theAllGroupDao;


    @PostMapping("/get_all")
    public TheAllGroupWithUsers getAll( @Validated @RequestBody  UserWithGroup userWithGroup){
        TheAllGroupWithUsers group = new TheAllGroupWithUsers();

        group.setAllGroup(theAllGroupDao.getGroupById(userWithGroup.getIdGroup()));
        if(group.getAllGroup()!=null &&  group.getAllGroup().getName().equals(userWithGroup.getNameGroup())) {
            group.setUsers(theGroupIdRepository.getAll(userWithGroup.getIdGroup()));
            theGroupIdRepository.save(userWithGroup.getIdGroup(),new TheGroupId(userWithGroup.getIdUser(),0));
            return group;
        }
        else{
            return null;
        }
    }


    @PostMapping("/save_user/{id}")
    public void save(@PathVariable("id") Long id, @Validated @RequestBody TheGroupId theGroupId){
        theGroupIdRepository.save(id, theGroupId);}

    @PutMapping("/delete_user/{id}")
    public void delete(@PathVariable("id") Long id, @Validated @RequestBody TheGroupId theGroupId){
        theGroupIdRepository.delete(id, theGroupId.getId());}
}
