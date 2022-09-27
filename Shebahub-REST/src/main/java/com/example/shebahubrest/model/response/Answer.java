package com.example.shebahubrest.model.response;


import java.time.LocalDate;

public class Answer {
    private Long postId;

    private String content;

    private LocalDate postedDate;

    private Question question;

    public Answer() {
    }

    public Answer(Long postId, String content, LocalDate postedDate, Question question) {
        this.postId = postId;
        this.content = content;
        this.postedDate = postedDate;
        this.question = question;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(LocalDate postedDate) {
        this.postedDate = postedDate;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
