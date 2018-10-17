package com.company;
/* Write a Point2D client that takes an integer value n from the command lane, generates n random points
in the unit square, and computes the distance separating the closest pair of point.  */

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

import java.awt.geom.Point2D;

public class TestPoint2D {

    public static void main(String[] args) {

        int n = StdIn.readInt();
        Point2D[] points = new Point2D[n];

        for (int i = 0; i < points.length; i++) {
            points[i] = new Point2D.Double(StdRandom.uniform(0.0, 1.0), StdRandom.uniform(0.0, 1.0));
        }

        double min = points[0].distance(points[1]);
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length - 1; j++) {
                if (points[i].distance(points[j]) < min) {
                    min = points[i].distance(points[j]);
                }
            }
        }

        StdOut.println("min = " + min);
    }
}

