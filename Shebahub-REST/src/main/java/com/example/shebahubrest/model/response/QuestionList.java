package com.example.shebahubrest.model.response;

import java.util.List;

public class QuestionList {
    List<Question> questions;

    public QuestionList(List<Question> questions) {
        this.questions = questions;
    }

    public QuestionList() {
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
