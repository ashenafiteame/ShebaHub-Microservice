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

    //    TODO get all users
    @GetMapping("/users")
    public User[] getAllUsers(){
        ResponseEntity<User[]> responseEntity = restTemplate.getForEntity("http://SHEBAHUB-USER/api/users", User[].class);
        User[] users = responseEntity.getBody();
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
    public Question[] getQuestionByUserId(@PathVariable Long userId){
        ResponseEntity<Question[]> responseEntity = restTemplate.getForEntity("http://SHEBAHUB-POST/api/qustion"+userId, Question[].class);
        return responseEntity.getBody();
    }

    //TODO add answer to question
    @PostMapping("/answer/{questionId}")
    public void addQuestion(@RequestBody CreateAnswerRequest createAnswerRequest, @PathVariable Long questionId){
        restTemplate.postForObject("http://SHEBAHUB-POST/api/answer"+questionId,createAnswerRequest, ResponseEntity.class);
    }

    // todo get answer by questionId
    @GetMapping("/answers/{questionId}")
    public Answer[] getAnswerByUserId(@PathVariable Long questionId){
        ResponseEntity<Answer[]> responseEntity = restTemplate.getForEntity("http://SHEBAHUB-POST/api/answer"+questionId , Answer[].class);
        return responseEntity.getBody();
    }

    //todo get Ratting by user id

    @GetMapping("/rating/{userId}")
    public Rating[] getUsersRating(@PathVariable Long userId){
        ResponseEntity<Rating[]> responseEntity = restTemplate.getForEntity("http://SHEBAHUB-RATTING/api/answer"+userId , Rating[].class);
        return responseEntity.getBody();
    }
    //todo get Ratting by question id
    @GetMapping("/rating/{questionId}")
    public Rating[] getQuestionsRating( @PathVariable Long questionId){
        ResponseEntity<Rating[]> responseEntity = restTemplate.getForEntity("http://SHEBAHUB-RATTING/api/question"+questionId , Rating[].class);
        return responseEntity.getBody();
    }
    //todo get Ratting by answer id
    @GetMapping("/rating/{answerId}")
    public Rating[] getAnswersRating(@PathVariable Long answerId){
        ResponseEntity<Rating[]> responseEntity = restTemplate.getForEntity("http://SHEBAHUB-RATTING/api/answer"+answerId , Rating[].class);
        return responseEntity.getBody();
    }

    //todo post Ratting by user
    @PostMapping("/rating")
    public void addRating(@RequestBody Rating rating, @PathVariable Long questionId){
        restTemplate.postForObject("http://SHEBAHUB-POST/api/answer"+questionId,rating, ResponseEntity.class);
    }

    
}
