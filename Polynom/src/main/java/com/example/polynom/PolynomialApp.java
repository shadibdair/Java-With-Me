package com.example.polynom;
import java.util.Scanner;

public class PolynomialApp {
    public static void main(String[] args) {
        Polynomial poly1 = gatherInput();
        Polynomial poly2 = gatherInput();
        display(poly1, poly2);
    }

    private static void display(Polynomial poly1, Polynomial poly2) {
        System.out.println("First polynomial: " + poly1);
        System.out.println("Second polynomial: " + poly2);
        System.out.println(poly1.equals(poly2) ? "Polynomials are equal" : "Polynomials are not equal");
        System.out.println("Addition result: " + poly1.add(poly2));
        System.out.println("Subtraction result: " + poly1.subtract(poly2));
        System.out.println("Derivative of first polynomial: " + poly1.derivative());
        System.out.println("Derivative of second polynomial: " + poly2.derivative());
    }

    private static Polynomial gatherInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms in the polynomial: ");
        int termCount = scanner.nextInt();
        double[] coefficients = new double[termCount];
        int[] powers = new int[termCount];

        System.out.println("Enter coefficients:");
        for (int i = 0; i < termCount; i++) {
            coefficients[i] = scanner.nextDouble();
        }

        System.out.println("Enter powers:");
        for (int i = 0; i < termCount; i++) {
            powers[i] = scanner.nextInt();
        }

        return new Polynomial(coefficients, powers);
    }
}
