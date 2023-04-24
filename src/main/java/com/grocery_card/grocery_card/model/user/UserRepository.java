package com.grocery_card.grocery_card.model.user;

import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findFirst1ByOrderByIdDesc();
}
