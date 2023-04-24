package com.grocery_card.grocery_card.model.groupid;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;

@Transactional
public class TheGroupId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @JsonProperty("id")
    private long id;
    @JsonProperty("status")
    private int status;

    public long getId() {
        return id;}

    public void setId(long id) {
        this.id = id;}

    public int getStatus() {
        return status;}

    public void setStatus(int status) {
        this.status = status;}

    public TheGroupId() {}

    public TheGroupId(long id, int status) {
        this.id = id;
        this.status = status;}

    @Override
    public String toString() {
        return "TheGroupId{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }
}
