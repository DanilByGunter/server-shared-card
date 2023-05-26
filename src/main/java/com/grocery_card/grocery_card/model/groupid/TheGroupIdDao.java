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
        String sql = "SELECT COUNT(*) group_" + String.valueOf(id);
        Integer count =  getJdbcTemplate().queryForObject(sql, Integer.class);
        Integer status = count == 0 ? 1:0;
        sql = "INSERT INTO group_" + String.valueOf(id) + "(id_user, status) VALUES(" +
                String.valueOf(theGroupId.getId()) + "," + String.valueOf(status) + ")";
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
    public TheAllGroupWithUsers getTheAllGroupWithUsers(UserWithGroup user){
        save(user.getIdGroup(), new TheGroupId(user.getIdUser(), 1));
        List<UsersGroup> users = getAll(user.getIdGroup());
        String sql = "SELECT tag.id, tag.name, tag.photo FROM the_all_group AS tag WHERE id = " + String.valueOf(user.getIdGroup());
        List<TheAllGroup> theAllGroup = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<TheAllGroup>(TheAllGroup.class));
        TheAllGroupWithUsers theAllGroupWithUsers = new TheAllGroupWithUsers();
        theAllGroupWithUsers.setAllGroup(theAllGroup.get(0));
        theAllGroupWithUsers.setUsers(users);
        System.out.println(theAllGroupWithUsers.toString());
        return theAllGroupWithUsers;
    }
//    public List<UserswithGroup> getUsersWithGorup(long id){
//        String sql = "select * from the_all_group join group_" + String.valueOf(id) + " where id=" + String.valueOf(id);
//        List<UserswithGroup> group = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserswithGroup>(UserswithGroup.class));
//
//        for (UserswithGroup us:
//             group) {
//            System.out.println(us.getId() + " " + us.getId_user() + " " + us.getName() + " " + us.getStatus());
//        }
//        return group;
//    }

//    @Override
//    public TheAllGroupWithUsers getGroup(long id) {
//        String sql = "select id_user, status,user.name ,user.id,user.photo ,the_all_group.id as group_id," +
//                "the_all_group.name as group_name, the_all_group.photo as group_photo from group_"+id+" " +
//                "inner join user on id_user = user.id " +
//                "inner join the_all_group on "+id+" = the_all_group.id;";
//        Li
//        return null;
//    }
}