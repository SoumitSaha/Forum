package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false, updatable = false)
    private long id;
    private String name;
    private String email;
    private String photo_url;

    public Users() {
    }

    public Users(String name, String email, String photo_url) {
        // this.user_id = user_id;
        this.name = name;
        this.email = email;
        this.photo_url = photo_url;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    @Override
    public String toString() {
        return "Users{" +
                "user_id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", photo_url='" + photo_url + '\'' +
                '}';
    }
}
