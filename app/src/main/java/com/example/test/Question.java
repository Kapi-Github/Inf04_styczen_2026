package com.example.test;

public class Question {
    private String question, ansA, ansB, ansC;
    private int image;
    private char correct;

    public Question(String question, int image, String ansA, String ansB, String ansC, char correct){
        this.question = question;
        this.image = image;
        this.ansA = ansA;
        this.ansB = ansB;
        this.ansC = ansC;
        this.correct = correct;
    }

    public char getCorrectAnswer(){
        return this.correct;
    }

    public String getQuestion() {
        return this.question;
    }

    public int getImage(){
        return this.image;
    }

    public String getAnsA(){
        return this.ansA;
    }

    public String getAnsB(){
        return this.ansB;
    }

    public String getAnsC(){
        return this.ansC;
    }
}
