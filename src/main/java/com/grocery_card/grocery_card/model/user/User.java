package com.grocery_card.grocery_card.model.user;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.Arrays;

@Transactional
@Validated
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String name;
    @Lob
    private byte[] photo;

    public User() {
    }

    public User(long id, String name, byte[] photo) {
        this.id = id;
        this.name = name;
        this.photo = photo;
    }

    public long getId_user() {
        return id;}

    public void setId_user(long id) {
        this.id = id;}

    public String getName() {
        return name;}

    public void setName(String name) {
        this.name = name;}

    public byte[] getPhoto() {
        return photo;}

    public void setPhoto(byte[] photo) {
        this.photo = photo;}

    @Override
    public String toString() {
        return "User{" +
                "id_user=" + id +
                ", name='" + name + '\'' +
                ", photo=" + Arrays.toString(photo) +
                '}';
    }
}
