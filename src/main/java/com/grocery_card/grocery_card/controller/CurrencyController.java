package com.grocery_card.grocery_card.controller;

import com.grocery_card.grocery_card.model.currency.Currency;
import com.grocery_card.grocery_card.model.currency.CurrencyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    @Autowired
    private CurrencyDao currencyDao;

    @GetMapping("/get_all")
    public List<Currency> getAllMetrics(){
        return currencyDao.getAllCurrencies();}

    @GetMapping("/get_count")
    public Long getCountCurrencies(){
        return currencyDao.getCountCurrencies();}

    @GetMapping("/{id}")
    public Currency getMetricById(@PathVariable("id") Integer id) {
        return currencyDao.getCurrencyById(id);}

    @PostMapping("/save")
    public void save(@RequestBody Currency currency){
        currencyDao.save(currency);}
}
