package com.grocery_card.grocery_card.model.check;

import com.grocery_card.grocery_card.dto.HistoryCheck;
import com.grocery_card.grocery_card.dto.ProductCheck;
import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Transactional
public class CheckDao extends JdbcDaoSupport implements CheckRepository{
    @Override
    public void createTable(long id) {
        String sql = "CREATE TABLE check_" + String.valueOf(id) + "(id_product BIGINT PRIMARY KEY AUTO_INCREMENT,\n" +
                "                      id_category INT,\n" +
                "                      id_metric INT,\n" +
                "                      id_shop INT,\n" +
                "                      id_user BIGINT,\n" +
                "                      id_buyer BIGINT,\n" +
                "                      product_name VARCHAR(64),\n" +
                "                      product_count REAL,\n" +
                "                      price REAL,\n" +
                "                      status BIT,\n" +
                "                      date_first DATETIME,\n" +
                "                      date_buy DATETIME,\n" +
                "                      FOREIGN KEY (id_category) REFERENCES category(id),\n" +
                "                      FOREIGN KEY (id_metric) REFERENCES metric(id),\n" +
                "                      FOREIGN KEY (id_shop) REFERENCES shop(id),\n" +
                "                      FOREIGN KEY (id_user) REFERENCES user(id),\n" +
                "                      FOREIGN KEY (id_buyer) REFERENCES user(id))";
        getJdbcTemplate().execute(sql);}

    @Override
    public List<ProductCheck> getAllActive(Long id) {
        String sql = "SELECT ch.product_name, cat.name AS category_name, \n" +
                "ch.product_count, m.name AS metric_name, ch.date_first, u.name AS user_name\n" +
                "FROM check_" + String.valueOf(id) + " ch\n" +
                "INNER JOIN category cat ON cat.id = ch.id_category\n" +
                "INNER JOIN metric m ON m.id = ch.id_metric\n" +
                "INNER JOIN user u ON u.id = ch.id_user\n" +
                "WHERE ch.status = 0\n" +
                "ORDER BY ch.date_first ASC";
        List<ProductCheck> productChecks = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<ProductCheck>(ProductCheck.class));
        return productChecks;
    }

    @Override
    public List<HistoryCheck> getAllHistory(Long id) {
        String sql = "SELECT ch.product_name, cat.name AS category_name, sh.name AS shop_name, \n" +
                "ch.product_count, m.name AS metric_name, ch.price, ch.date_buy,\n" +
                "u.name AS user_name, b.name AS user_buyer\n" +
                "FROM check_" + String.valueOf(id) + " ch\n" +
                "INNER JOIN category cat ON cat.id = ch.id_category\n" +
                "INNER JOIN metric m ON m.id = ch.id_metric\n" +
                "INNER JOIN shop sh ON sh.id = ch.id_shop\n" +
                "INNER JOIN user u ON u.id = ch.id_user\n" +
                "INNER JOIN user b ON b.id = ch.id_buyer\n" +
                "WHERE ch.status = 1\n" +
                "ORDER BY ch.date_first ASC";
        List<HistoryCheck> products = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<HistoryCheck>(HistoryCheck.class));
        return products;
    }

    @Override
    public int save(long id, Check check){
        String sql = "INSERT check_" + String.valueOf(id) + "(status, product_name, id_category, " +
                "product_count, id_metric, id_user, date_first) VALUES(0, '" +
                String.valueOf(check.getProduct_name()) +  "', " +
                String.valueOf(check.getId_category()) +  ", " +
                String.valueOf(check.getProduct_count()) +  ", " +
                String.valueOf(check.getId_metric()) +  ", " +
                String.valueOf(check.getId_user()) +  ", now())";
        getJdbcTemplate().execute(sql);
        sql = "SELECT id_product FROM check_" + String.valueOf(id) + " ORDER BY id_product DESC LIMIT 1";
        Integer count = getJdbcTemplate().queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public void updateStatus(long id, Check check) {
        String sql = "UPDATE check_" + String.valueOf(id) +
                " SET id_buyer = "  + String.valueOf(check.getId_buyer()) + ", " +
                "price = " + String.valueOf(check.getPrice()) + ", " +
                "id_shop = " + String.valueOf(check.getId_shop()) + ", " +
                "status = 1, date_buy = now() WHERE id_product = " + String.valueOf(check.getId_product());
        getJdbcTemplate().execute(sql);
    }

    @Override
    public void delete(long id, long product_id) {
        String sql = "DELETE FROM check_" + String.valueOf(id) + " WHERE id_product = " + String.valueOf(product_id);
        getJdbcTemplate().execute(sql);
    }
}