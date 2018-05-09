package com.company;
//histogram. Suppose that the standard input stream is a sequence of double values. Write a program that takes an
// integer n and two double values lo and hi from the command line and uses Stddraw to plot histogram of the count
// to the numbers in  the standard input stream that fill in each of the n intervals defined by divideing(lo,hi)
// into n equal-sized intervals

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;


public class Main {

    public static void main(String[] args) {


        double[] values = StdIn.readAllDoubles();

        int N = StdIn.readInt();
        double l = StdIn.readDouble();
        double r = StdIn.readDouble();

        double lengthOfInterval = (r + l) / N;
        StdDraw.setYscale(0, values.length);
        StdDraw.setXscale(l, r);

        for (double i = l; i <= r - lengthOfInterval; i += lengthOfInterval) {
            int count = 0;
            for (int j = 0; j < values.length; j++) {
                if (values[j] <= i + lengthOfInterval && values[j] > i) {
                    count++;
                }
            }

            if (count != 0) {
               StdDraw.rectangle((i + lengthOfInterval) - lengthOfInterval / 2.0 , count / 2.0, lengthOfInterval / 2.0, count / 2.0);
            }

        }
    }
}
