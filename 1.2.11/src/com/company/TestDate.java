package com.company;
/*
 Develop an implementation SmartDate of our Date API that raises an exception
if the date is not legal.
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

class SmarteDate {
    private final int month;
    private final int day;
    private final int year;

    public SmarteDate(int m, int d, int y) {
        if (m < 1 || d < 1 & y < 1 || m > 12 || d > 31) {
            throw new RuntimeException("IllegalArgumentException");
        }
        month = m;
        day = d;
        year = y;
    }

    public int month() {
        return month;
    }

    public int day() {
        return day;
    }

    public int year() {
        return year;
    }

    public String toString() {
        return month() + "/" + day() + "/" + year();
    }
}

public class TestDate {

    public static void main(String[] args) {

        int m = StdIn.readInt();
        int d = StdIn.readInt();
        int y = StdIn.readInt();
        SmarteDate date = new SmarteDate(m, d, y);
        StdOut.println(date.toString());
    }
}
