package com.grocery_card.grocery_card.model.groupid;

import com.grocery_card.grocery_card.dto.UsersGroup;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Transactional
public interface TheGroupIdRepository {
    public void createTable(long id);
    public void save(long id, TheGroupId theGroupId);
    public void delete(long id, long id_user);
    public List<UsersGroup> getAll(long id);
}
