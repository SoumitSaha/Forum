package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Comments implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false, updatable = false)
    private long id;
    private String comment;
    @ManyToOne
    private Discussion discussion_id;
    @ManyToOne
    private Users user_id;
    private Date posted_at;

    public Comments() {
    }

    public Comments(String comment, Discussion discussion_id, Users user_id, Date posted_at) {
        this.comment = comment;
        this.discussion_id = discussion_id;
        this.user_id = user_id;
        this.posted_at = posted_at;
    }

    public long getid() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public Discussion getDiscussion_id() {
        return discussion_id;
    }

    public Users getUser_id() {
        return user_id;
    }

    public Date getPosted_at() {
        return posted_at;
    }

    public void setid(long id) {
        this.id = id;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setDiscussion_id(Discussion discussion_id) {
        this.discussion_id = discussion_id;
    }

    public void setUser_id(Users user_id) {
        this.user_id = user_id;
    }

    public void setPosted_at(Date posted_at) {
        this.posted_at = posted_at;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "comment_id=" + id +
                ", comment='" + comment + '\'' +
                ", discussion_id=" + discussion_id +
                ", user_id=" + user_id +
                ", posted_at=" + posted_at +
                '}';
    }
}
