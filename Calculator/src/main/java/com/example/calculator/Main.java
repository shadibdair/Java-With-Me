package com.example.calculator;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        CalculatorUI calculatorUI = new CalculatorUI();
        calculatorUI.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
