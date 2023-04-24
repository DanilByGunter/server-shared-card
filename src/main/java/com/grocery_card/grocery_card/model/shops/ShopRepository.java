package com.grocery_card.grocery_card.model.shops;

import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ShopRepository extends CrudRepository<Shop, Integer> {
}
