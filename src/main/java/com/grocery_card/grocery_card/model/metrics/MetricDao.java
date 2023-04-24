package com.grocery_card.grocery_card.model.metrics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MetricDao {
    @Autowired
    private MetricRepository repository;
    public void save(Metric metric){
        repository.save(metric);}
    public List<Metric> getAllMetrics(){
        List<Metric> metrics = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(metrics::add);
        return metrics;
    }
    public Metric getMetricById(Integer id){
        return repository.findById(id).orElse(null);}
    public void delete(Metric metric){
        repository.delete(metric);}
}
