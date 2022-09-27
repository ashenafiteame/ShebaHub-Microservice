package com.example.shebahubrest.model.response;

public class RattingList {

    private Rating rating;

    public RattingList() {
    }

    public RattingList(Rating rating) {
        this.rating = rating;
    }

    public Rating getRatting() {
        return rating;
    }

    public void setRatting(Rating rating) {
        this.rating = rating;
    }
}
