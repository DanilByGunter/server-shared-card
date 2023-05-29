package com.grocery_card.grocery_card.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.grocery_card.grocery_card.model.groupid.TheGroupId;
import com.grocery_card.grocery_card.model.user.User;

public class UserWithGroup {
    @JsonProperty("id_group")
    private long idGroup;
    @JsonProperty("name_group")
    private String nameGroup;
    private TheGroupId user;

    public UserWithGroup(long idGroup, String nameGroup, TheGroupId user) {
        this.idGroup = idGroup;
        this.nameGroup = nameGroup;
        this.user = user;

    }

    public UserWithGroup() {
    }

    public TheGroupId getUser() {
        return user;
    }

    public void setUser(TheGroupId user) {
        this.user = user;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public long getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(long idGroup) {
        this.idGroup = idGroup;
    }


}
