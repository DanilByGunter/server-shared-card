package com.grocery_card.grocery_card.model.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDao {
    @Autowired
    private UserRepository repository;
    public void save(User user){
        repository.save(user);}
    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(users::add);
        return users;}
    public User getUserById(Long id){
        return repository.findById(id).orElse(null);}
    public Long findLastId(){
        User user = repository.findFirst1ByOrderByIdDesc().get();
        return user.getId_user();}
    public void updateUserName(Long id, String name){
        User user = repository.findById(id).orElse(null);
        user.setName(name);
        repository.save(user);
    }
    public void updateUserPhoto(Long id, byte[] photo){
        User user = repository.findById(id).orElse(null);
        user.setPhoto(photo);
        repository.save(user);
    }
    public void delete(User user){
        repository.delete(user);
    }
}

