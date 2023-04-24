package com.grocery_card.grocery_card.model.theallgroup;

import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface TheAllGroupRepository extends CrudRepository<TheAllGroup, Long> {
    Optional<TheAllGroup> findFirst1ByOrderByIdDesc();
}
