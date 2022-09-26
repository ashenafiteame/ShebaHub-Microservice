package com.example.shebahubpost.question;


import com.example.shebahubpost.model.request.QuestionCreatRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/question")
public class QuestionController {
    private final QuestionService questionService;
    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping()
    public void addQuestion(@RequestBody QuestionCreatRequest questionCreatRequest){
        Question question = new Question(questionCreatRequest.getQuestionContent(), LocalDate.now(),questionCreatRequest.getCategory());

        questionService.addQuestion(question);

    }
    @GetMapping()
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @PutMapping("/{id}")
    public void updateQuestion(@PathVariable(value = "id") Long questionId,@RequestBody Question question ){
        questionService.updateQuestion(question);
    }
}
