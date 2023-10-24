package com.example.calculator;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculatorUI {

    private TextField display;
    private CalculatorLogic calculator;

    public CalculatorUI() {
        calculator = new CalculatorLogic();
    }

    // Initialize the user interface for the calculator
    public void start(Stage primaryStage) {
        display = new TextField();
        display.setEditable(false);

        GridPane grid = new GridPane();

        // Add the display at the top
        grid.add(display, 0, 0, 4, 1);

        // Array of button labels for clarity
        String[][] buttonLabels = {
                {"7", "8", "9", "/"},
                {"4", "5", "6", "*"},
                {"1", "2", "3", "-"},
                {"0", ".", "+/-", "+"},
                {"=", "C"}
        };

        // Loop to create buttons and set their actions
        for (int i = 0; i < buttonLabels.length; i++) {
            for (int j = 0; j < buttonLabels[i].length; j++) {
                Button button = new Button(buttonLabels[i][j]);

                // Creating effectively final variables
                final String label = buttonLabels[i][j];

                button.setOnAction(e -> handleButtonClick(label));
                grid.add(button, j, i + 1);
            }
        }


        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculator");
        primaryStage.show();
    }

    // Handle button clicks
    private void handleButtonClick(String label) {
        switch (label) {
            case "=":
                calculator.computeResult();
                display.setText(String.valueOf(calculator.getCurrentNumber()));
                break;
            case "C":
                calculator.reset();
                display.setText("");
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                calculator.setOperation(label);
                display.setText("");
                break;
            case ".":
                calculator.addDecimalPoint();
                display.setText(display.getText() + ".");
                break;
            case "+/-":
                calculator.toggleSign();
                display.setText(String.valueOf(calculator.getCurrentNumber()));
                break;
            default:  // Number buttons
                calculator.addDigit(Integer.parseInt(label));
                display.setText(display.getText() + label);
                break;
        }
    }
}
