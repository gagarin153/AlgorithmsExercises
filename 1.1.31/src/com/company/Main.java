package com.company;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.awt.*;

import static edu.princeton.cs.introcs.StdRandom.bernoulli;

public class Main {

    /*   Random connections. Write a program that takes as command-line arguments an integer n and a double value p
         (between 0 an 1), plots n equally spaced dots of size 0.05 on the circumference of a circle, and the, with probability
          p for each pair of points, draw a gray line connecting them.
     */

    public static class Point
    {
        public double x;
        public double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    };
    public static void main(String[] args) {
        
        int n = 15;
        StdDraw.setXscale(-n,n);
        StdDraw.setYscale(-n,n);
        StdDraw.line(-n,0,n,0);
        StdDraw.line(-0,-n,0,n);
        StdDraw.setPenRadius(0.05);
        StdOut.print("Введите количество отрезков");
        int numberOfpoint = StdIn.readInt();
        StdOut.print("Введите Вероятность");
        double p = StdIn.readDouble();
        Point[] points = new Point[numberOfpoint + 2];
        double radious = 10.0;
        double stroke = 40.0 / numberOfpoint;

        int index = 0;
        for(double x = - radious; x <= radious; x += stroke) {
            double y = Math.sqrt(Math.pow(radious,2.0) - Math.pow(x,2.0));

            points[index] =  new Point(x,y);
            index ++;
            points[index] =  new Point(x,-y);
            StdDraw.point(x,y);
            StdDraw.point(x,-y);
            index++;
        }


        StdDraw.setPenRadius(0.005);
        for(int i = 0; i < points.length - 1; i++ ) {
            for(int j = i + 1; j < points.length; j++ ) {
                if(bernoulli(p)) {
                    StdDraw.setPenColor(Color.gray);
                    StdDraw.line(points[i].x, points[i].y, points[j].x, points[j].y);
                }
            }
        }
    }
}
