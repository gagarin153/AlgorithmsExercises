package com.company;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Main {

    //Write code fragment that prints true if the double variables x and y are both strictly between 0 and 1 and false otherwise
    public static void main(String[] args) {

	double x = StdIn.readDouble();
	double y = StdIn.readDouble();

	if(x < 1 && y < 1 && x > 0 && y > 0) {
        StdOut.print(true);
    } else {
	    StdOut.print(false);
    }

    }
}
