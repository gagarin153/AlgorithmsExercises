package com.company;
/* 1.2.16
Rational numbers. Implement an immutable data type Rational for rational
numbers that supports addition, subtraction, multiplication, and division.

public class Rational
    Rational(int numerator. int denominator)
    Rational plus(Rational b) sum of this number and b
    Rational minus(Rational b) difference of this number and b
    Rational times(Rational b) product of this number and b
    Rational divides(Rational b) quotient of this number and b
    boolean equals(Rational that) is this number equal to that ?
    String toString() string representation
You do not have to worry about testing for overflow (see Exercise 1.2.17), but use as
instance variables two long values that represent the numerator and denominator to
limit the possibility of overflow. Use Euclid’s algorithm (see page 4) to ensure that the
numerator and denominator never have any common factors. Include a test client that
exercises all of your method

1.2.17 Robust implementation of rational numbers. Use assertions to develop an implementation
of Rational (see Exercise 1.2.16) that is immune to overflow.
*/

import edu.princeton.cs.algs4.StdOut;

 class Rational {
    private final int numerator;
    private final int denominator;

    private static int gcd(int p, int q) {

        if(q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

    public Rational(int n, int d) {
        int gcd = gcd(Math.abs(d), Math.abs(n));
        denominator = d / gcd;
        numerator = n / gcd;
    }


     public Rational plus(Rational that) {
        assert (this.numerator + that.numerator) < 32267 || (this.numerator + that.numerator) > -32268 : "overflow";
         if (this.denominator == that.denominator) {
             return new Rational(this.numerator + this.denominator, this.denominator);
         }
                return new Rational(this.numerator * that.denominator + this.denominator * that.numerator, this.denominator * that.denominator);
     }

     public Rational minus(Rational that) {
         assert (this.numerator - that.numerator) < 32267 || (this.numerator - that.numerator) > -32268 : "overflow";
         if (this.denominator == that.denominator) {
             return new Rational(this.numerator - this.denominator, this.denominator);
         }
         return new Rational(this.numerator * that.denominator - this.denominator * that.numerator, this.denominator * that.denominator);
     }

     public Rational times(Rational that) {
         assert (this.numerator * that.numerator) < 32267 || (this.numerator * that.numerator) > -32268 ||
                 (this.denominator * that.denominator) < 32267 || (this.denominator * that.denominator) > -32268  : "overflow";
        return  new Rational(this.numerator * that.numerator, this.denominator * that.denominator);
     }


     public Rational divedBy(Rational that) {
         assert (this.numerator * that.denominator) < 32267 || (this.numerator * that.denominator) > -32268 ||
                 (this.denominator * that.numerator) < 32267 || (this.denominator * that.numerator) > -32268  : "overflow";
         return new Rational(this.numerator * that.denominator, this.denominator * that.numerator);

     }

     public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null) return false;
        if (this.getClass() != that.getClass()) return false;
        if (this.numerator != ((Rational) that).numerator) return false;
        if (this.denominator != ((Rational) that).denominator) return false;
        return true;
     }


         public String toString() {
        return numerator + "/" + denominator;
    }
}

public class RationalTest {

    public static void main(String[] args) {

        Rational a = new Rational(32765, 11);
        Rational b = new Rational(100, 11);
        Rational c = b.divedBy(a);
        StdOut.println(c);
        StdOut.println(a.equals(b));
        Rational d = a.plus(b);
    }
}
