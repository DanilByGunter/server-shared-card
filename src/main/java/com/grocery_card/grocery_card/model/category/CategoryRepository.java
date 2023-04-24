package com.grocery_card.grocery_card.model.category;

import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
