package com.grocery_card.grocery_card.model.groupid;

import com.grocery_card.grocery_card.dto.TheAllGroupWithUsers;
import com.grocery_card.grocery_card.dto.UserWithGroup;
import com.grocery_card.grocery_card.dto.UsersGroup;
import com.grocery_card.grocery_card.model.theallgroup.TheAllGroup;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Transactional
public class TheGroupIdDao extends JdbcDaoSupport implements TheGroupIdRepository {
    @Autowired
    private TheGroupIdRepository repository;
    @Override
    public void createTable(long id) {
        String sql = "CREATE TABLE group_" + String.valueOf(id) + " (id_user BIGINT PRIMARY KEY, " +
                "status bit, FOREIGN KEY (id_user) REFERENCES user(id))";
        getJdbcTemplate().execute(sql);}

    @Override
    public void save(long id, TheGroupId theGroupId){
        String sql = "INSERT INTO group_" + String.valueOf(id) + "(id_user, status) VALUES(" +
                String.valueOf(theGroupId.getId()) + "," + theGroupId.getStatus() + ")";
        getJdbcTemplate().execute(sql);}

    @Override
    public void delete(long id, long id_user) {
        String sql = "DELETE FROM group_" + String.valueOf(id) + " WHERE id_user = " + String.valueOf(id_user);
        getJdbcTemplate().execute(sql);
    }

    @Override
    @Transactional
    public List<UsersGroup> getAll(long id) {
        String sql = "SELECT u.id, u.name, u.photo, gp.status FROM group_" + String.valueOf(id) +
                " AS gp INNER JOIN user AS u ON gp.id_user = u.id";
        List<UsersGroup> users = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UsersGroup>(UsersGroup.class));
        return users;
    }
}