package com.company;

import edu.princeton.cs.introcs.StdOut;

public class Main {

    // Write a recursive static method that computes the value of ln (n!)
    public static double factorial(double number) {
        if (number == 1) {
            return number;
        }
        return number * factorial(number - 1);
    }

    public static double ln(double number) {

        int count = 0;
        if (number <= 1) {
            return count;
        }
        count++;
        return count + ln(number / Math.E);
    }

    public static void main(String[] args) {


        StdOut.println(ln(1024));
    }
}
