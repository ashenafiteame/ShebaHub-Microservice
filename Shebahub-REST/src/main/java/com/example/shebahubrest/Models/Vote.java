package com.example.shebahubrest.Models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vote")
public class Vote {
    private String userId;


    @EmbeddedId
    private VoteId id;

    public Vote() {
    }

    public Vote(VoteId id) {
        this.id = id;

    }

    public VoteId getId() {
        return id;
    }

    public void setId(VoteId id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}

