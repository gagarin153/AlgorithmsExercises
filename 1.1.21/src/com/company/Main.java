package com.company;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Main {

    public static void main(String[] args) {
	    //Write a program that reads in lines from standard input with each line containing a name and two integers
        // and then uses printf() to print a table with column of the names, the integers and result of dividing the first
        // by second, accurate three decimal places

        int numb1 = StdIn.readInt();
        int numb2 = StdIn.readInt();
        String name = StdIn.readString();
        StdOut.printf("Name: %s\tNumbers: %d, %d\tResult of division: %.3f\n", name, numb1, numb2, (double) numb1/numb2);
    }
}
