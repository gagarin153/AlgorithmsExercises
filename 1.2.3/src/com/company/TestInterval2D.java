package com.company;

/* Write an Interval2d client that takes an int value n as command-line argument n, min, max and generation n random2D
intervals whose width and height are uniformly distributed between min and max in the unit square. Draw them on StdDraw
and print the number of pairs of intervals that intersect and the number of intervals that a contained in one another.
 */
import edu.princeton.cs.algs4.*;

import java.awt.*;

public class TestInterval2D {

    public static void main(String[] args) {
        int n = StdIn.readInt();
        int min = StdIn.readInt();
        int max = StdIn.readInt();
        Interval2D[] intervals = new Interval2D[n];
        Point2D[][] points = new Point2D[n][2];
        StdDraw.setXscale(0.0, 10);
        StdDraw.setYscale(0.0, 10);
        StdDraw.setPenRadius(0.01);
        StdDraw.line(0.0, 0.0, 10, 0.0);
        StdDraw.line(0.0, 0.0, 0.0, 10);
        StdDraw.setPenColor(Color.red);
        StdDraw.setPenRadius(0.001);

        for (int i = 0; i < intervals.length; i++) {

            double start = StdRandom.uniform(min, max);
            double endX = StdRandom.uniform(start, max);
            double endY = StdRandom.uniform(start, max);
            Interval1D x = new Interval1D(start, endX);
            Interval1D y = new Interval1D(start, endY);

            intervals[i] = new Interval2D(x, y);
            points[i][0] = new Point2D(start, start);
            points[i][1] = new Point2D(endY, endX);

//            StdDraw.rectangle((x.min() + x.max())/2 ,(y.max() + y.min())/2, x.length()/2, y.length()/2);
            StdOut.println(intervals[i]);
            intervals[i].draw();

        }

        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i + 1; j < intervals.length - 1; j++) {
                if (intervals[i].intersects(intervals[j])) {
                    StdOut.println(intervals[i] + " intersect " + intervals[j]);
                }
                if (intervals[i].contains(points[j][0]) && intervals[i].contains(points[j][1])) {
                    StdOut.println(intervals[i] + " contain " + intervals[j]);
                }
            }
        }


    }
}
