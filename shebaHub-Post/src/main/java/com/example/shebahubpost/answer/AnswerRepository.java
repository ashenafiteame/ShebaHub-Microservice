package com.example.shebahubpost.answer;

import com.example.shebahubpost.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer,Long> {

    @Query("SELECT a From Answer a WHERE a.question = ?1")
    List<Answer> findAnswerByQuestion(Question question);
}
