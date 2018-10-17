package com.company;
/* 1.2.13 Using our implementation of Date as a model (page 91), develop an implementation
of Transaction.
1.2.14 Using our implementation of equals() in Date as a model (page 103), develop
implementations of equals() for Transaction.
*/

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import  java.lang.Object;
import java.util.Date;

class Transaction {
    private final String who;
    private final Date when;
    private final double amount;

    public  Transaction(String who,Date when,double amount) {
        this.who = who;
        this.when = when;
        this.amount = amount;
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


public class TestTransaction {

    public static void main(String[] args) {
        String who = StdIn.readString();
        Date when = new Date();
        double amount = StdIn.readDouble();

        Transaction transaction1 = new Transaction(who, when, amount);
        StdOut.println(transaction1.toString());

         who = StdIn.readString();
        when = new Date();
        amount = StdIn.readDouble();
        Transaction transaction2 = new Transaction(who, when, amount);

        StdOut.println(transaction1.equals(transaction2));
    }
}
