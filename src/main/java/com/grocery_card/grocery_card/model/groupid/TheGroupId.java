package com.grocery_card.grocery_card.model.groupid;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.grocery_card.grocery_card.model.theallgroup.TheAllGroup;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.relational.core.mapping.MappedCollection;

@Transactional
public class TheGroupId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @JsonProperty("id")
    @Column(name = "id_user")
    private long id;
    @JsonProperty("status")
    private int status;

    public TheGroupId() {
    }

    public TheGroupId(long id, int status) {
        this.id = id;
        this.status = status;
    }



    public long getId() {
        return id;}

    public void setId(long id) {
        this.id = id;}

    public int getStatus() {
        return status;}

    public void setStatus(int status) {
        this.status = status;}


    @Override
    public String toString() {
        return "TheGroupId{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }
}
