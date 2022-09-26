package com.example.shebahubpost.answer;


import com.example.shebahubpost.question.Question;
import com.example.shebahubpost.post.Post;

import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Answer extends Post {

    @ManyToOne(fetch = FetchType.LAZY,optional = true)
    private Question question;
    public Answer( String content, LocalDate postedDate) {
        super(content, postedDate);
    }

    public Answer() {
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "question=" + question +
                '}';
    }
}
