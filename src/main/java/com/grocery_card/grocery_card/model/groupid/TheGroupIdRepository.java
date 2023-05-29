package com.grocery_card.grocery_card.model.groupid;

import com.grocery_card.grocery_card.dto.TheAllGroupWithUsers;
import com.grocery_card.grocery_card.dto.UserWithGroup;
import com.grocery_card.grocery_card.dto.UsersGroup;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public interface TheGroupIdRepository {
    void createTable(long id);
    void save(long id, TheGroupId theGroupId);
    void delete(long id, long id_user);
    List<UsersGroup> getAll(long id);
}
