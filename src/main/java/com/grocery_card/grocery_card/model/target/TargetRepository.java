package com.grocery_card.grocery_card.model.target;

import com.grocery_card.grocery_card.dto.HistoryTarget;
import com.grocery_card.grocery_card.dto.ProductTarget;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Repository
public interface TargetRepository {
    public void createTable(long id);
    public List<ProductTarget> getAllActive(Long id);
    public List<HistoryTarget> getAllHistory(Long id);
    public int save(long id, Target Target);
    public void updateStatus(long id, Target Target);
    public void delete(long id, long product_id);
}
