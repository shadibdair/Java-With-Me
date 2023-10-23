package com.example.polynom;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;


// The Polynomial class represents a polynomial as a list of terms.
// Each term is an instance of the PolynomialElement class.
public class Polynomial {

    // List of terms that make up the polynomial.
    private List<PolynomialElement> terms;

    // Constructor to initialize the polynomial using arrays of coefficients and exponents.
    public Polynomial(double[] constants, int[] exponents) {
        if (constants.length != exponents.length)
            throw new IllegalArgumentException("Mismatch in lengths");

        terms = new ArrayList<>();
        for (int i = 0; i < exponents.length; i++) {
            terms.add(new PolynomialElement(constants[i], exponents[i]));
        }
        organizeTerms();
    }

    // Private constructor to initialize the polynomial from a list of terms.
    private Polynomial(List<PolynomialElement> termsList) {
        this.terms = new ArrayList<>(termsList);
    }

    // Organizes terms by combining like terms and sorting by descending exponent.
    private void organizeTerms() {
        // Sort terms by descending exponent
        terms.sort((t1, t2) -> Integer.compare(t2.getExponent(), t1.getExponent()));

        // Combine like terms (terms with the same exponent)
        for (int i = 0; i < terms.size() - 1; i++) {
            PolynomialElement current = terms.get(i);
            PolynomialElement next = terms.get(i + 1);
            if (current.getExponent() == next.getExponent()) {
                terms.set(i, new PolynomialElement(current.getConstant() + next.getConstant(), current.getExponent()));
                terms.remove(i + 1);
                i--;
            }
        }
    }

    // Adds this polynomial to another polynomial and returns the result.
    public Polynomial add(Polynomial other) {
        List<PolynomialElement> newTerms = new ArrayList<>(this.terms);
        newTerms.addAll(other.terms);
        return new Polynomial(newTerms);
    }

    // Subtracts another polynomial from this polynomial and returns the result.
    public Polynomial subtract(Polynomial other) {
        List<PolynomialElement> newTerms = new ArrayList<>(this.terms);
        newTerms.addAll(other.terms.stream().map(term -> new PolynomialElement(-term.getConstant(), term.getExponent())).collect(Collectors.toList()));
        return new Polynomial(newTerms);
    }

    // Returns the derivative of this polynomial.
    public Polynomial derivative() {
        List<PolynomialElement> newTerms = terms.stream()
                .filter(term -> term.getExponent() != 0)
                .map(term -> new PolynomialElement(term.getConstant() * term.getExponent(), term.getExponent() - 1))
                .collect(Collectors.toList());
        return new Polynomial(newTerms);
    }

    // Checks if this polynomial is equal to another object.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Polynomial other = (Polynomial) obj;
        return terms.equals(other.terms);
    }

    // Returns a string representation of the polynomial.
    @Override
    public String toString() {
        return terms.stream().map(PolynomialElement::toString).collect(Collectors.joining());
    }
}
