package com.grocery_card.grocery_card.model.theallgroup;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.Arrays;

@Transactional
@Validated
@Entity
public class TheAllGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String name;
    @Lob
    private byte[] photo;


    public long getId() {
        return id;}

    public void setId(long id) {
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
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", photo=" + Arrays.toString(photo) +
                '}';
    }
}
