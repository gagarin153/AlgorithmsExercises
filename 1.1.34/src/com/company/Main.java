package com.company;

//Filtering. Which of the following require saving all the values from standard input(in an array, say), and which could
//be implemented as a filter using only a fixed number od variables and arrays of fixed size (nit depended on n)?
// For each, the input comes from standard input and consists of n real numbers between 0 and 1.

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

//• Print the maximum and minimum numbers.
//• Print the median of the numbers.
//• Print the k th smallest value, for k less than 100.
//• Print the sum of the squares of the numbers.
//• Print average of the n numbers.
//• Print the percentage of numbers greater then the average.
//• Print the numbers in increasing order.
//• Print the numbers in random order.
public class Main {

    public static void main(String[] args) {
       // printAverageOfNumbers();
        printTheKthSmallestvalue();
    }

    public static void printAverageOfNumbers() {
        int sum = 0;
        int average = 0;
        StdOut.println("Input n");
        int n = StdIn.readInt();

       for(int i = 0; i < n; i++) {
           sum += StdIn.readInt();
       }


        average = sum / n;
        StdOut.println(average);
    }

    public static void printTheKthSmallestvalue() {
        StdOut.println("Input k");
        int k = StdIn.readInt();
        int n = k + 5;
        int smallestNumber = 0;

        for(int i = 0; i < n; i++) {
            int x = StdIn.readInt();
            if(i <= k ) {
                if (i != 0) {
                    if (smallestNumber > x) {
                        smallestNumber = x;
                    };
                } else {
                    smallestNumber = x;
                }
            }
        }

        StdOut.println("The smallest k-th number is " + smallestNumber);
    }
}
