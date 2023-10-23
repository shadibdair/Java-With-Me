package com.example.quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class QuizLoader {

    //Loads questions from a given filename.
    public static List<Question> loadQuestions(String filename) throws FileNotFoundException {
        List<Question> questions = new ArrayList<>();

        // Initialize the scanner to read from the file.
        Scanner input = new Scanner(new File(filename));

        // Loop through the file content as long as there are lines left to read.
        while (input.hasNext()) {
            // Read the question text.
            String questionText = input.nextLine();

            // Read the correct answer.
            String correctAnswer = input.nextLine();

            // Prepare a list to hold options (incorrect ones at first).
            List<String> options = new ArrayList<>();

            // Read the next 3 lines as incorrect answers.
            for (int i = 0; i < 3; i++) {
                options.add(input.nextLine());
            }

            // Construct a new Question object and add it to the questions list.
            questions.add(new Question(questionText, correctAnswer, options));
        }

        // Close the scanner to free up resources.
        input.close();

        return questions;
    }
}
