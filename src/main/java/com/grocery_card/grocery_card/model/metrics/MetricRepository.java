package com.grocery_card.grocery_card.model.metrics;

import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface MetricRepository extends CrudRepository<Metric, Integer> {
}
