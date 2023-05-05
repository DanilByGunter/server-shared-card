package com.grocery_card.grocery_card.model.currency;

import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CurrencyRepository extends CrudRepository<Currency, Integer> {
}
