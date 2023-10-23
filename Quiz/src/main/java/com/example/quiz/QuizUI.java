package com.example.quiz;

import com.example.quiz.Question;
import com.example.quiz.QuizLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;

public class QuizUI extends Application {

    // UI components declaration
    private Label questionLabel;
    private ToggleGroup optionsGroup;
    private RadioButton[] optionButtons;
    private Button nextButton;
    private Button resetButton;
    private Label feedbackLabel;

    // List to hold loaded questions and tracking variables
    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    public void start(Stage primaryStage) {
        // Initialize UI components
        questionLabel = new Label("Question text here");
        optionsGroup = new ToggleGroup();
        optionButtons = new RadioButton[4];
        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new RadioButton("Option " + (i + 1));
            optionButtons[i].setToggleGroup(optionsGroup);
        }

        nextButton = new Button("Next");
        resetButton = new Button("Start Over");
        feedbackLabel = new Label();

        // Arrange UI components in layout
        VBox layout = new VBox(10, questionLabel);
        layout.getChildren().addAll(optionButtons);
        layout.getChildren().addAll(nextButton, resetButton, feedbackLabel);

        // Set the primary stage
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Quiz Application");
        primaryStage.show();

        // Load questions from file
        try {
            questions = QuizLoader.loadQuestions("exam.txt");
        } catch (FileNotFoundException e) {
            feedbackLabel.setText("Error loading questions.");
            return;
        }

        // Display the first question
        displayNextQuestion();

        // Set button actions
        nextButton.setOnAction(event -> checkAndProceed());
        resetButton.setOnAction(event -> resetQuiz());
    }

    private void displayNextQuestion() {
        // Check if all questions are answered
        if (currentQuestionIndex >= questions.size()) {
            feedbackLabel.setText("Quiz completed! Your score: " + score + "/" + questions.size());
            nextButton.setDisable(true);
            return;
        }

        // Display the current question and shuffle options
        Question question = questions.get(currentQuestionIndex);
        questionLabel.setText(question.getQuestionText());
        Collections.shuffle(question.getOptions());

        for (int i = 0; i < 4; i++) {
            optionButtons[i].setText(question.getOptions().get(i));
            optionButtons[i].setSelected(false);
        }

        feedbackLabel.setText("");
    }

    private void checkAndProceed() {
        // Check the selected option and proceed to next question
        RadioButton selectedOption = (RadioButton) optionsGroup.getSelectedToggle();
        if (selectedOption == null) {
            feedbackLabel.setText("Please select an option.");
            return;
        }

        if (selectedOption.getText().equals(questions.get(currentQuestionIndex).getCorrectAnswer())) {
            score++;
        }

        currentQuestionIndex++;
        displayNextQuestion();
    }

    private void resetQuiz() {
        // Reset the quiz to the beginning
        currentQuestionIndex = 0;
        score = 0;
        nextButton.setDisable(false);
        displayNextQuestion();
    }

    // Main method to launch the application
    public static void main(String[] args) {
        launch(args);
    }
}
