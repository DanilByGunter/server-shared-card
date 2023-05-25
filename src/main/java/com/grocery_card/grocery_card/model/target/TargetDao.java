package com.grocery_card.grocery_card.model.target;

import com.grocery_card.grocery_card.dto.HistoryTarget;
import com.grocery_card.grocery_card.dto.ProductTarget;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class TargetDao extends JdbcDaoSupport implements TargetRepository {
    @Override
    public void createTable(long id) {
        String sql = "CREATE TABLE target_" + String.valueOf(id) + "(id_product BIGINT PRIMARY KEY AUTO_INCREMENT,\n" +
                "                      id_category INT,\n" +
                "                      id_shop INT,\n" +
                "                      id_user BIGINT,\n" +
                "                      id_buyer BIGINT,\n" +
                "                      product_name VARCHAR(64),\n" +
                "                      price REAL,\n" +
                "                      status BIT,\n" +
                "                      date_first DATETIME,\n" +
                "                      date_buy DATETIME,\n" +
                "                      FOREIGN KEY (id_category) REFERENCES category(id),\n" +
                "                      FOREIGN KEY (id_shop) REFERENCES shop(id),\n" +
                "                      FOREIGN KEY (id_user) REFERENCES user(id),\n" +
                "                      FOREIGN KEY (id_buyer) REFERENCES user(id))";
        getJdbcTemplate().execute(sql);
    }

    @Override
    public List<ProductTarget> getAllActive(Long id) {
        String sql = "SELECT t.product_name, cat.name AS category_name, \n" +
                "t.price, t.date_first, u.name AS user_name\n" +
                "FROM target_" + String.valueOf(id) + " t\n" +
                "INNER JOIN category cat ON cat.id = t.id_category\n" +
                "INNER JOIN user u ON u.id = t.id_user\n" +
                "WHERE t.status = 0\n" +
                "ORDER BY t.date_first ASC";
        List<ProductTarget> productTargets = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<ProductTarget>(ProductTarget.class));
        return productTargets;
    }

    @Override
    public List<HistoryTarget> getAllHistory(Long id) {
        String sql = "SELECT t.product_name, cat.name AS category_name, sh.name AS shop_name, \n" +
                "t.price, t.date_buy, u.name AS user_name, b.name AS user_buyer\n" +
                "FROM target_" + String.valueOf(id) + " t\n" +
                "INNER JOIN category cat ON cat.id = t.id_category\n" +
                "INNER JOIN shop sh ON sh.id = t.id_shop\n" +
                "INNER JOIN user u ON u.id = t.id_user\n" +
                "INNER JOIN user b ON b.id = t.id_buyer\n" +
                "WHERE t.status = 1\n" +
                "ORDER BY t.date_first ASC";
        List<HistoryTarget> targets = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<HistoryTarget>(HistoryTarget.class));
        return targets;
    }

    @Override
    public int save(long id, Target target) {
        String sql = "INSERT target_" + String.valueOf(id) + "(status, product_name, id_category, " +
                "price, id_user, date_first) VALUES(0, '" +
                String.valueOf(target.getProduct_name()) + "', " +
                String.valueOf(target.getId_category()) + ", " +
                String.valueOf(target.getPrice()) + ", " +
                String.valueOf(target.getId_user()) + ", now())";
        getJdbcTemplate().execute(sql);
        sql = "SELECT id_product FROM target_" + String.valueOf(id) + " ORDER BY id_product DESC LIMIT 1";
        Integer count = getJdbcTemplate().queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public void updateStatus(long id, Target target) {
        String sql = "UPDATE target_" + String.valueOf(id) +
                " SET id_buyer = " + String.valueOf(target.getId_buyer()) + ", " +
                "price = " + String.valueOf(target.getPrice()) + ", " +
                "id_shop = " + String.valueOf(target.getId_shop()) + ", " +
                "status = 1, date_buy = now() WHERE id_product = " + String.valueOf(target.getId_product());
        getJdbcTemplate().execute(sql);
    }

    @Override
    public void delete(long id, long product_id) {
        String sql = "DELETE FROM target_" + String.valueOf(id) + " WHERE id_product = " + String.valueOf(product_id);
        getJdbcTemplate().execute(sql);
    }
}
