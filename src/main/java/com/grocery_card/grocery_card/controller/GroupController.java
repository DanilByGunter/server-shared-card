package com.grocery_card.grocery_card.controller;

import com.grocery_card.grocery_card.dto.NewName;
import com.grocery_card.grocery_card.dto.NewPhoto;
import com.grocery_card.grocery_card.model.check.CheckRepository;
import com.grocery_card.grocery_card.model.groupid.TheGroupIdRepository;
import com.grocery_card.grocery_card.model.target.TargetRepository;
import com.grocery_card.grocery_card.model.theallgroup.TheAllGroup;
import com.grocery_card.grocery_card.model.theallgroup.TheAllGroupDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    private TheAllGroupDao theAllGroupDao;
    @GetMapping("/get_all")
    public List<TheAllGroup> getAllGroups(){
        return theAllGroupDao.getAllGroups();}

    @GetMapping("/{id}")
    public TheAllGroup getGroupById(@PathVariable("id") Long id) {
        return theAllGroupDao.getGroupById(id);}

    @GetMapping("/last_id")
    public Long findLastId(){
        return theAllGroupDao.findLastId();}

    @PutMapping("/update_name")
    public void updateGroupName(@RequestBody NewName group){
        theAllGroupDao.updateGroupName(group.getId(), group.getName());}

    @PutMapping("/update_photo")
    public void updateGroupPhoto(@RequestBody NewPhoto group){
        theAllGroupDao.updateGroupPhoto(group.getId(), group.getPhoto());}

    @PostMapping("/save")
    public void save(@Validated @RequestBody TheAllGroup theAllGroup){
        BeanFactory context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TheGroupIdRepository theGroupIdRepository = (TheGroupIdRepository) context.getBean("theGroupIdRepository");
        CheckRepository checkRepository = (CheckRepository) context.getBean("checkRepository");
        TargetRepository targetRepository = (TargetRepository) context.getBean("targetRepository");
        theAllGroupDao.save(theAllGroup);
        long id = findLastId();
        theGroupIdRepository.createTable(id);
        checkRepository.createTable(id);
        targetRepository.createTable(id);
    }
}