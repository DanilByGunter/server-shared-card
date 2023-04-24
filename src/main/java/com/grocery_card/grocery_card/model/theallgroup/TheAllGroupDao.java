package com.grocery_card.grocery_card.model.theallgroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Validated
@Service
public class TheAllGroupDao{
    @Autowired
    private TheAllGroupRepository repository;
    public void save(@Validated TheAllGroup theAllGroup){
        repository.save(theAllGroup);}
    public List<TheAllGroup> getAllGroups(){
        List<TheAllGroup> theAllGroups = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(theAllGroups::add);
        return theAllGroups;}
    public TheAllGroup getGroupById(Long id){
        return repository.findById(id).orElse(null);}
    public Long findLastId(){
        TheAllGroup group = repository.findFirst1ByOrderByIdDesc().get();
        return group.getId();}
    public void updateGroupName(Long id, String name){
        TheAllGroup group = repository.findById(id).orElse(null);
        group.setName(name);
        repository.save(group);
    }
    public void updateGroupPhoto(Long id, byte[] photo){
        TheAllGroup group = repository.findById(id).orElse(null);
        group.setPhoto(photo);
        repository.save(group);}
    public void delete(TheAllGroup theAllGroup){
        repository.delete(theAllGroup);
    }
}
