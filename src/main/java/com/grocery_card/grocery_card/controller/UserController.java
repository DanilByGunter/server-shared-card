package com.grocery_card.grocery_card.controller;

import com.grocery_card.grocery_card.dto.NewName;
import com.grocery_card.grocery_card.dto.NewPhoto;
import com.grocery_card.grocery_card.model.user.User;
import com.grocery_card.grocery_card.model.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao userDao;
    @GetMapping("/get_all")
    public List<User> getAllUsers(){
        return userDao.getAllUsers();}
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userDao.getUserById(id);}
    @GetMapping("/last_id")
    public Long findLastId(){
        return userDao.findLastId();}
    @PutMapping("/update_name")
    public void updateUserName(@RequestBody NewName user){
        userDao.updateUserName(user.getId(), user.getName());}
    @PutMapping("/update_photo")
    public void updateUserPhoto(@RequestBody NewPhoto user){
        userDao.updateUserPhoto(user.getId(), user.getPhoto());}
    @PostMapping("/save")
    public Long save(@RequestBody User user){
        userDao.save(user);
        return userDao.findLastId();}
}
