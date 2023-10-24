package com.example.calculator;

public class CalculatorLogic {

    private double currentNumber;
    private double storedNumber;
    private String operation;

    public CalculatorLogic() {
        reset();
    }

    // Resets the calculator state
    public void reset() {
        currentNumber = 0;
        storedNumber = 0;
        operation = "";
    }

    // Sets the current operation and stores the current number
    public void setOperation(String op) {
        storedNumber = currentNumber;
        operation = op;
        currentNumber = 0;
    }

    // Adds a digit to the current number
    public void addDigit(int digit) {
        currentNumber = currentNumber * 10 + digit;
    }

    // Adds a decimal point to the current number
    public void addDecimalPoint() {
        // Check if current number is a whole number
        if (currentNumber == (int) currentNumber) {
            currentNumber += 0.0;
        }
    }

    // Toggles the sign of the current number
    public void toggleSign() {
        currentNumber = -currentNumber;
    }

    // Computes the result based on the stored operation and numbers
    public double computeResult() {
        switch (operation) {
            case "+":
                currentNumber = storedNumber + currentNumber;
                break;
            case "-":
                currentNumber = storedNumber - currentNumber;
                break;
            case "*":
                currentNumber = storedNumber * currentNumber;
                break;
            case "/":
                if (currentNumber != 0) {
                    currentNumber = storedNumber / currentNumber;
                } else {
                    // Handle division by zero, reset calculator and return 0
                    reset();
                    return 0;
                }
                break;
        }
        operation = "";
        return currentNumber;
    }

    public double getCurrentNumber() {
        return currentNumber;
    }
}
