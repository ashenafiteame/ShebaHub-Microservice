package com.example.shebahubpost.model.request;

import java.util.List;

public class QuestionCreatRequest {
    private String questionContent;

    private List<String> category;

    public QuestionCreatRequest() {
    }

    public QuestionCreatRequest(String questionContent, List<String> category) {
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
