package com.example.shebahubpost.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void addQuestion(Question question){
        questionRepository.save(question);
    }
    public List<Question> getAllQuestions(){
        return questionRepository.findAll();
    }
    public void updateQuestion(Question question){
        questionRepository.save(question);
    }

    public void deleteQuestion(Long questionId){
        questionRepository.deleteById(questionId);
    }

    public Optional<Question> getElementById(Long questionId) {
        return questionRepository.findById(questionId);
    }
}
