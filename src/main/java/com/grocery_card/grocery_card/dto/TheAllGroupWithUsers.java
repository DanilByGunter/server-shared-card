package com.grocery_card.grocery_card.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.grocery_card.grocery_card.dto.UsersGroup;
import com.grocery_card.grocery_card.model.theallgroup.TheAllGroup;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class TheAllGroupWithUsers {
    @JsonProperty("all_group")
    private TheAllGroup allGroup;
    private List<UsersGroup> users;

    public TheAllGroup getAllGroup() {
        return allGroup;
    }

    public void setAllGroup(TheAllGroup allGroup) {
        this.allGroup = allGroup;
    }

    public List<UsersGroup> getUsers() {
        return users;
    }

    public void setUsers(List<UsersGroup> users) {
        this.users = users;
    }
}
