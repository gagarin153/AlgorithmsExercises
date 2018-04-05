package com.company;

import edu.princeton.cs.introcs.StdOut;

public class Main {
    // Give the sequence of value of p and q that are computed when Euclid's algorithm is used to compute the greatest
    // common divisor of 105 and 24. Use your program to compute the greatest common divisior of 1111111 ana 1234567
    public static int gcd(int p, int q) {
        StdOut.printf("q = %d, p = %d\n", q, p);
        if (q == 0)
            return p;
        int r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args) {
        gcd(105, 24);
        StdOut.print(gcd(1234567, 1111111));
    }
}
