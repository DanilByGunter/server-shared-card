package com.grocery_card.grocery_card.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewPhoto {
    @JsonProperty("id")
    private long id;
    @JsonProperty("photo")
    private byte[] photo;

    public NewPhoto() {
    }

    public NewPhoto(long id, byte[] photo) {
        this.id = id;
        this.photo = photo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
