package com.example.quiz;

import java.util.ArrayList;
import java.util.List;

// Represents a multiple-choice question with one correct answer and several options.
public class Question {

    // Text of the question.
    private String questionText;

    // The correct answer to the question.
    private String correctAnswer;

    // List of possible answers including the correct one.
    private List<String> options;


    // Constructs a new Question object.
    public Question(String questionText, String correctAnswer, List<String> options) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.options = new ArrayList<>(options);
        this.options.add(correctAnswer);  // Add the correct answer to the list of options.
    }

    // Returns the text of the question.
    public String getQuestionText() {
        return questionText;
    }

    // Returns the correct answer to the question.
    public String getCorrectAnswer() {
        return correctAnswer;
    }


    // Returns the list of possible answers including the correct one.
    public List<String> getOptions() {
        return options;
    }
}
