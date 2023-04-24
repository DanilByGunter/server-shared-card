package com.grocery_card.grocery_card.model.check;

import com.grocery_card.grocery_card.dto.HistoryCheck;
import com.grocery_card.grocery_card.dto.ProductCheck;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Repository
public interface CheckRepository {
    public void createTable(long id);
    public List<ProductCheck> getAllActive(Long id);
    public List<HistoryCheck> getAllHistory(Long id);
    public int save(long id, Check check);
    public void updateStatus(long id, Check check);
    public void delete(long id, long product_id);
}
