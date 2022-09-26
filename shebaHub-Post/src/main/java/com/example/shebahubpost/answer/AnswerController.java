package com.example.shebahubpost.answer;

import com.example.shebahubpost.model.request.CreateAnswerRequest;
import com.example.shebahubpost.question.Question;
import com.example.shebahubpost.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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
    @PostMapping("/{questionId}")
    public void addAnswer(@PathVariable(value = "questionId") Long questionId, @RequestBody CreateAnswerRequest createAnswerRequest){

        Question question = questionService.getElementById(questionId).get();
        question.addAnswer(new Answer(createAnswerRequest.getAnswerContent(), LocalDate.now()));
        questionService.updateQuestion(question);
    }

    @GetMapping("/{questionId}")
    public List<Answer> getAnswer(@PathVariable(value = "questionId") Long questionID){
        Question question = questionService.getElementById(questionID).get();
        List<Answer> answer = answerService.findByQuestionID(question);
        return answer;
    }


}
