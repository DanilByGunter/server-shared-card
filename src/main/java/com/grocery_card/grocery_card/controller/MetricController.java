package com.grocery_card.grocery_card.controller;

import com.grocery_card.grocery_card.model.metrics.Metric;
import com.grocery_card.grocery_card.model.metrics.MetricDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metric")
public class MetricController {
    @Autowired
    private MetricDao metricDao;

    @GetMapping("/get_all")
    public List<Metric> getAllMetrics(){
        return metricDao.getAllMetrics();}

    @GetMapping("/get_count")
    public Long getCountMetric(){
        return metricDao.getCountMetric();}

    @GetMapping("/{id}")
    public Metric getMetricById(@PathVariable("id") Integer id) {
        return metricDao.getMetricById(id);}

    @PostMapping("/save")
    public void save(@RequestBody Metric metric){
        metricDao.save(metric);}
}
