package com.grocery_card.grocery_card.model.currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyDao {
    @Autowired
    private CurrencyRepository repository;
    public void save(Currency currency){
        repository.save(currency);}

    public List<Currency> getAllCurrencies(){
        List<Currency> currencies = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(currencies::add);
        return currencies;
    }

    public Long getCountCurrencies(){
        return repository.count();}

    public Currency getCurrencyById(Integer id){
        return repository.findById(id).orElse(null);}

    public void delete(Currency currency){
        repository.delete(currency);}
}
