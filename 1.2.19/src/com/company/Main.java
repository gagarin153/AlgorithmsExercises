package com.company;

/*
Parsing. Develop the parse constructors for your Date and Transaction implementations
of Exercise 1.2.13 that take a single String argument to specify the
initialization values, using the formats given in the table below.

Date integers separated by slashes 5/22/1939
Transaction customer, date, and amount,separated by whitespace Turing 5/22/1939 11.99
 */
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.lang.reflect.Field;

class Date {
    private final int month;
    private final int day;
    private final int year;

    public Date( String date) {

        String[] fields = date.split("/");
        month = Integer.parseInt(fields[0]);
        day = Integer.parseInt(fields[1]);
        year = Integer.parseInt(fields[2]);
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

class Transaction {
    private final String who;
    private final Date when;
    private final double amount;

    public  Transaction(String date) {
        String[] fields = date.split(" ");
        who = fields[0];
        when = new Date(fields[1]);
        amount = Double.parseDouble(fields[2]);
    }

    public String who() {
        return who;
    }

    public Date when() {
        return when;
    }

    public double amount() {
        return amount;
    }

    public String toString() {
        return who() + " " + when().toString() + " " + amount();
    }

    public boolean equals(Object x) {
        if (this == x) return true;
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        Transaction that = (Transaction) x;
        if (this.who !=  that.who) return  false;
        //if (this.when != that.when) return  false;
        if (this.amount != that.amount) return  false;
        return true;
    }
}


public class Main {

    public static void main(String[] args) {
	    String date = StdIn.readLine();
	    Transaction transaction = new Transaction(date);
        StdOut.println(transaction.toString());

    }
}
