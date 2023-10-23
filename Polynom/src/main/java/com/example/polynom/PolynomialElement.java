package com.example.polynom;

// The PolynomialElement class represents a single term of a polynomial.
public class PolynomialElement {

    // The power (or exponent) of the polynomial term (e.g., for 3x^2, exponent is 2)
    private int exponent;

    // The coefficient of the polynomial term (e.g., for 3x^2, constant is 3)
    private double constant;

    // Constructor for the PolynomialElement.
    public PolynomialElement(double constant, int exponent) {
        this.exponent = exponent;
        this.constant = constant;
    }

    // Retrieves the exponent of this polynomial term.
    public int getExponent() {
        return this.exponent;
    }

    // Retrieves the coefficient of this polynomial term.
    public double getConstant() {
        return this.constant;
    }

    // Converts the polynomial term to a string representation.
    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        if (constant > 0) strBuilder.append('+'); // Add '+' for positive coefficients
        strBuilder.append(constant);
        if (exponent > 1) strBuilder.append("x^").append(exponent);
        else if (exponent == 1) strBuilder.append('x');
        return strBuilder.toString();
    }
}
