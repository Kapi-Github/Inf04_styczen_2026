package com.example.test;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Question> questions;
    private int currentQuestionNumber;
    private Button nextBtn;
    private RadioButton answerA, answerB, answerC;
    private RadioGroup answersGroup;
    private Question currentQuestion;
    private int points;
    private TextView questionContent;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.nextBtn = findViewById(R.id.nextBtn);
        this.answerA = findViewById(R.id.answerA);
        this.answerB = findViewById(R.id.answerB);
        this.answerC = findViewById(R.id.answerC);
        this.answersGroup = findViewById(R.id.questionAnswers);
        this.questionContent = findViewById(R.id.questionContent);
        this.image = findViewById(R.id.questionImage);

        this.currentQuestionNumber = 1;
        this.questions = new ArrayList<Question>();
        this.questions.add(new Question("Które to schronisko?", R.drawable.zad1, "Na Rysiance.", "Na Wielkiej Raczy.", "Na Wielkiej Ryczerzowej.", 'B'));
        this.questions.add(new Question("Zwierzę na zdjęciu to", R.drawable.zad2, "owczarek.", "wilk.", "kozica.", 'A'));
        this.questions.add(new Question("W oddali są widoczne", R.drawable.zad3, "Himalaje.", "Alpy.", "Tatry.", 'C'));
        this.currentQuestion = this.questions.get(this.currentQuestionNumber - 1);

        this.nextBtn.setOnClickListener(v -> {
            if(
                this.answerA.isChecked() && this.currentQuestion.getCorrectAnswer() == 'A' ||
                this.answerB.isChecked() && this.currentQuestion.getCorrectAnswer() == 'B' ||
                this.answerC.isChecked() && this.currentQuestion.getCorrectAnswer() == 'C'
            ){
                this.points++;
            }

            this.setNextQuestion();
        });
    }

    private void setNextQuestion(){
        if(this.currentQuestionNumber == 3){
            this.currentQuestionNumber = 1;
        }else{
            this.currentQuestionNumber++;
        }

        this.currentQuestion = this.questions.get(this.currentQuestionNumber - 1);
        this.loadQuestionData();
    }

    private void loadQuestionData(){
        this.questionContent.setText(this.currentQuestion.getQuestion());
        this.image.setImageResource(this.currentQuestion.getImage());
        this.answerA.setText(this.currentQuestion.getAnsA());
        this.answerB.setText(this.currentQuestion.getAnsB());
        this.answerC.setText(this.currentQuestion.getAnsC());
        this.answersGroup.clearCheck();
    }
}