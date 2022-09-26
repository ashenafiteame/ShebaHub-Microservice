package com.example.shebahubpost.question;

import com.example.shebahubpost.answer.Answer;
import com.example.shebahubpost.post.Post;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Question  extends Post {


    @OneToMany(
            mappedBy = "question",
            orphanRemoval = true,
            cascade = {CascadeType.ALL}
    )
    List<Answer> answers  = new ArrayList<>();

    @Column(name = "category")
    @ElementCollection(targetClass = String.class)
    private List<String> category;


    public Question(String content, LocalDate postedDate, List<String> category) {
        super(content, postedDate);
        this.category = category;
    }

    public Question() {

    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }
    public void addAnswer(Answer answer){
        if (!this.answers.contains(answer)){
            this.answers.add(answer);
            answer.setQuestion(this);
        }


    }
    public void removeAnswer(Answer answer){
        if (this.answers.contains(answer)){
            this.answers.remove(answer);
            answer.setQuestion(null);
        }


    }
}
