package com.example.shebahubpost.answer;


import com.example.shebahubpost.question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;
    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }
    public void addAnswer(Answer answer){
        answerRepository.save(answer);
    }

    public void updateAnswer(Answer answer){
        answerRepository.save(answer);
    }

    public void deleteAnswer(Long answerId){
        answerRepository.deleteById(answerId);
    }
    public List<Answer> findByQuestionID(Question question){
        return answerRepository.findAnswerByQuestion(question);
    }
}
