package com.example.shebahubrest.model.request;

import java.util.List;

public class QuestionCreateRequest {
    private String questionContent;

    private List<String> category;

    public QuestionCreateRequest() {
    }

    public QuestionCreateRequest(String questionContent, List<String> category) {
        this.questionContent = questionContent;
        this.category = category;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }
}
