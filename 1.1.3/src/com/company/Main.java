package com.company;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    int[] numbers = new int[3];
	    for(int i = 0; i < 3; i++) {
	        numbers[i] = StdIn.readInt();
        }

        if(numbers[0] == numbers[1] && numbers[0] == numbers[2]) {
            StdOut.print("equal");
        } else {
	        StdOut.print("Not equal");
        }
    }
}
