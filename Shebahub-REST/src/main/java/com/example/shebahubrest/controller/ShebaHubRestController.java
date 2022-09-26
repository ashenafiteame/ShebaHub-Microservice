package com.example.shebahubrest.controller;

import com.example.shebahubrest.model.request.CreateAnswerRequest;
import com.example.shebahubrest.model.request.QuestionCreateRequest;
import com.example.shebahubrest.model.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/shebahub/api")
public class ShebaHubRestController {

    @Autowired
    RestTemplate restTemplate;

//    @GetMapping("/{}")

    /**
     * GET ALL USER
     * CREATE USER
     * DELETE USER
     *
     * create POST - QUESTION
     * CREATE POST - ANSWER
     * DELETE ANSWER
     *
     * RATE QUESTION
     * RATE ANSWER
     *
     *
     * */


    //    TODO get all users
    @GetMapping("/users")
    public UserList getAllUsers(){
        UserList  users = restTemplate.getForObject("http://SHEBAHUB-USER/api/users", UserList.class);
        return users;
    }

    // todo post user
    @PostMapping("/user")
    public void addUser(@RequestBody User user){
        restTemplate.postForObject("http://SHEBAHUB-USER/api/user",user, ResponseEntity.class);
    }

    // TODO get specific user
    @GetMapping("/user/{userId}")
    public User getUser(@PathVariable Long userId){
        User user = restTemplate.getForObject("http://SHEBAHUB-USER/api/users"+userId , User.class);
        return user;
    }

    //todo createQustion
    @PostMapping("/question")
    public void createQuestion(@RequestBody QuestionCreateRequest questionCreateRequest){
        restTemplate.postForObject("http://SHEBAHUB-POST/api/qustion",questionCreateRequest, ResponseEntity.class);
    }
    //TODO get question by userid
    @GetMapping("/questions/{userId}")
    public QuestionList getQuestionByUserId(@PathVariable Long userId){
        QuestionList questions = restTemplate.getForObject("http://SHEBAHUB-POST/api/qustion"+userId , QuestionList.class);
        return questions;
    }

    //TODO add answer to question
    @PostMapping("/question")
    public void addQuestion(@RequestBody CreateAnswerRequest createAnswerRequest){
        restTemplate.postForObject("http://SHEBAHUB-POST/api/qustion",createAnswerRequest, ResponseEntity.class);
    }

    // todo get answer by questionId
    @GetMapping("/answers/{questionId}")
    public AnswerList getAnswerByUserId(@PathVariable Long questionId){
        AnswerList answers = restTemplate.getForObject("http://SHEBAHUB-POST/api/answer"+questionId , AnswerList.class);
        return answers;
    }

    //todo get Ratting by user id

    @GetMapping("/rating/{userId}")
    public RattingList getUsersRating(@PathVariable Long userId){
        RattingList ratings = restTemplate.getForObject("http://SHEBAHUB-RATTING/api/answer"+userId , RattingList.class);
        return ratings;
    }
    //todo get Ratting by question id
    @GetMapping("/rating/{questionId}")
    public int getQuestionsRating( @PathVariable Long questionId){
        int ratings = restTemplate.getForObject("http://SHEBAHUB-RATTING/api/answer"+questionId , Integer.class);
        return ratings;
    }
    //todo get Ratting by answer id
    @GetMapping("/rating/{answerId}")
    public int getAnswersRating(@PathVariable Long answerId){
        int ratings = restTemplate.getForObject("http://SHEBAHUB-RATTING/api/answer"+answerId , Integer.class);
        return ratings;
    }

    //todo post stuff












    //        List<User>  users = restTemplate.getForObject("http://SHEBAHUB-POST")
    //        List<User>  users = restTemplate.getForObject("http://SHEBAHUB-RATTING")


//    public List<User> getAllUsers(@PathVariable("userId") )





}
