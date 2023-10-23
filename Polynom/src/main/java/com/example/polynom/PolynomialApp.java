package com.example.polynom;
import java.util.Scanner;

public class PolynomialApp {

    public static void main(String[] args) {
        // Gather input coefficients and powers for two polynomials from the user
        Polynomial poly1 = gatherInput();
        Polynomial poly2 = gatherInput();

        // Display operations and results for the input polynomials
        display(poly1, poly2);
    }

    /**
     * This method displays various operations on the two provided polynomials:
      - Checks if they are equal
      - Performs and displays addition of the two polynomials
      - Performs and displays subtraction of the two polynomials
      - Displays the derivative of each polynomial
     */
    private static void display(Polynomial poly1, Polynomial poly2) {
        System.out.println("First polynomial: " + poly1);
        System.out.println("Second polynomial: " + poly2);

        // Check and display if the two polynomials are equal
        System.out.println(poly1.equals(poly2) ? "Polynomials are equal" : "Polynomials are not equal");

        // Display the result of adding the two polynomials
        System.out.println("Addition result: " + poly1.add(poly2));

        // Display the result of subtracting the second polynomial from the first
        System.out.println("Subtraction result: " + poly1.subtract(poly2));

        // Display the derivative of each polynomial
        System.out.println("Derivative of first polynomial: " + poly1.derivative());
        System.out.println("Derivative of second polynomial: " + poly2.derivative());
    }

    /**
     This method gathers input from the user for a polynomial:
      - Number of terms in the polynomial
      - Coefficients for each term
      - Powers for each term
     */
    private static Polynomial gatherInput() {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the number of terms in the polynomial
        System.out.print("Enter the number of terms in the polynomial: ");
        int termCount = scanner.nextInt();

        double[] coefficients = new double[termCount];
        int[] powers = new int[termCount];

        // Gather the coefficients for each term from the user
        System.out.println("Enter coefficients:");
        for (int i = 0; i < termCount; i++) {
            coefficients[i] = scanner.nextDouble();
        }

        // Gather the powers for each term from the user
        System.out.println("Enter powers:");
        for (int i = 0; i < termCount; i++) {
            powers[i] = scanner.nextInt();
        }

        // Return a new Polynomial object constructed from the input coefficients and powers
        return new Polynomial(coefficients, powers);
    }
}
