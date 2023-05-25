package com.grocery_card.grocery_card.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.grocery_card.grocery_card.model.user.User;

public class UserWithGroup {
    @JsonProperty("id_group")
    private long idGroup;
    @JsonProperty("name_group")
    private String nameGroup;
    @JsonProperty("id_user")
    private long idUser;

    public UserWithGroup(long idGroup, String nameGroup, long idUser) {
        this.idGroup = idGroup;
        this.nameGroup = nameGroup;
        this.idUser = idUser;

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

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }
}
