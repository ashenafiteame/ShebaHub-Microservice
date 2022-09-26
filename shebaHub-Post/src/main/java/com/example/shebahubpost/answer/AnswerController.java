package com.example.shebahubpost.answer;

import com.example.shebahubpost.question.Question;
import com.example.shebahubpost.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/answer")
public class AnswerController {
    private final AnswerService answerService;
    private final QuestionService questionService;

    @Autowired
    public   AnswerController(AnswerService answerService, QuestionService questionService){
        this.answerService = answerService;
        this.questionService = questionService;
    }
}
