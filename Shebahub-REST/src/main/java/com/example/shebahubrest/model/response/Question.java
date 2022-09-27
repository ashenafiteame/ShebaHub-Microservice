package com.example.shebahubrest.model.response;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Question {

    private Long postId;

    private String content;

    private LocalDate postedDate;
    List<Answer> answers  = new ArrayList<>();
    public Question() {
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Question(Long postId, String content, LocalDate postedDate, List<Answer> answers  ) {
        this.postId = postId;
        this.content = content;
        this.postedDate = postedDate;
        this.answers=answers;
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
}
