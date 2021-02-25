package com.example.demo.model;

import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Discussion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false, updatable = false)
    private long id;
    private String question;
    private Timestamp posted_at;
    @ManyToOne
    private Users user_id;

    public Discussion() {}

    public Discussion(String question, Timestamp posted_at, Users user_id) {
        // this.discussion_id = discussion_id;
        this.question = question;
        this.posted_at = posted_at;
        this.user_id = user_id;
    }

    public long getid() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public Date getPosted_at() {
        return posted_at;
    }

    public Users getUser_id() {
        return user_id;
    }

    public void setid(long id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setPosted_at(Timestamp posted_at) {
        this.posted_at = posted_at;
    }

    public void setUser_id(Users user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Discussion{" +
                "discussion_id=" + id +
                ", question='" + question + '\'' +
                ", posted_at=" + posted_at +
                ", user_id=" + user_id +
                '}';
    }
}
