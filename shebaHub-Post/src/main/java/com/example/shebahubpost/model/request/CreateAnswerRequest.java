package com.example.shebahubpost.model.request;

public class CreateAnswerRequest {
    String answerContent;
    public CreateAnswerRequest(){}
    public CreateAnswerRequest(String answerContent){
        this.answerContent = answerContent;
    }
    public String getAnswerContent(){
        return  answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }
}
