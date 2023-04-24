package com.grocery_card.grocery_card.model.metrics;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;

@Transactional
@Entity
public class Metric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String name;

    public int getId() {
        return id;}

    public void setId(int id) {
        this.id = id;}

    public String getName() {
        return name;}

    public void setName(String name) {
        this.name = name;}

    @Override
    public String toString() {
        return "Metrics{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
