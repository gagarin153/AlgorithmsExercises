package com.company;

/* Write an Interval1D client that takes an int value n as command-line argument, reads n intervals from standard input,
and prints all pairs that intersect */
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


public class TestInterval1D {

    public static void main(String[] args) {

        int n = StdIn.readInt();

        Interval1D[] intervals = new Interval1D[n];
        for (int i = 0; i < intervals.length; i++) {
            double min = StdRandom.uniform(0.0, 100.0);
            double max = StdRandom.uniform(0.0, 100.0);
            if (min > max) {
                double tmp = min;
                min = max;
                max = tmp;
            }
            intervals[i] = new Interval1D(min, max);

        }



        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i + 1; j < intervals.length - 1; j++) {
                if (intervals[i].intersects(intervals[j])) {
                    StdOut.println(intervals[i] + " " + intervals[j]);

                }
            }
        }

    }
}

