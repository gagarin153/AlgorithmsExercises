package com.company;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
Add a method dayOfTheWeek() to SmartDate that returns a String value
Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, or Sunday, giving the appropriate
day of the week for the date. You may assume that the date is in the 21st
century
 */
class SmartDate {
    private final int month;
    private final int day;
    private final int year;
    private String[] daysOfTheWeek = {" Saturday", "Sunday", "Monday", " Tuesday", " Wednesday", " Thursday", " Friday"};

    public SmartDate( int d, int m, int y) {
        if (m < 1 || d < 1 & y < 1 || m > 12 || d > 31 || m == 2 && d > 29 || y < 2000 || y % 4 != 0 && m == 2 && d > 28) {
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

    public String dayOfTheWeek() {
        int index = 0;

        for (int i = 2001; i < year + 1; i++) {
            if ((i - 1) % 4 == 0) {
                index += 2;
            } else {
                index += 1;
            }
            if (index > 6) index -= 7;

        }

        for (int i = 1; i < month; i++) {
            if (i < 8) {
                if ((i % 2) != 0) {
                    index += 3;
                } else {
                    if (i != 2) {
                        index += 2;
                    } else {
                        if (year % 4 == 0) {
                            index += 1;
                        }
                    }
                }
            } else {
                if ((i % 2) == 0) {
                    index += 3;
                } else {
                    index += 2;
                }
            }
            if (index > 6) {
                index -= 7;
            }

        }

        for(int i = 1; i < day; i++) {
            index++;
            if(index > 6) {
                index -= 7;
            }
        }

        return daysOfTheWeek[index];


    }
}


public class TestSmartData {


    public static void main(String[] args) {

        int d = StdIn.readInt();
        int m = StdIn.readInt();
        int y = StdIn.readInt();
        SmartDate date = new SmartDate(d, m, y);
        StdOut.println(date.dayOfTheWeek());
    }
}


