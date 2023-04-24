package com.grocery_card.grocery_card.controller;

import com.grocery_card.grocery_card.model.shops.Shop;
import com.grocery_card.grocery_card.model.shops.ShopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shops")
public class ShopController {
    @Autowired
    private ShopDao shopDao;
    @GetMapping("/get_all")
    public List<Shop> getAllShops(){
        return shopDao.getAllShops();}
    @GetMapping("/{id}")
    public Shop getShopById(@PathVariable("id") Integer id) {
        return shopDao.getShopById(id);}
    @PostMapping("/save")
    public void save(@RequestBody Shop shop){
        shopDao.save(shop);}
}
