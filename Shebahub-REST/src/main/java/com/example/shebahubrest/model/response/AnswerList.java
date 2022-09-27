package com.example.shebahubrest.model.response;

import java.util.List;

public class AnswerList {

    List<Answer> answers;

    public AnswerList() {
    }

    public AnswerList(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
