package com.company;

/* 1.3.16 UsingreadInts() on page 126 as a model,write a static method readDates()for Date that reads dates from
standard input in the format specified in the table on page 119 and returns an array containing them.
1.3.17 Do Exercise 1.3.16 for Transaction.
 */
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;


class Queue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int n;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        n++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;
        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

    }
}

class Date {
    private final int month;
    private final int day;
    private final int year;


    public Date(String date) {

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

    public Transaction(String date) {
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
        if (this.who != that.who) return false;
        //if (this.when != that.when) return  false;
        if (this.amount != that.amount) return false;
        return true;
    }
}


public class Main {

    public static Date[] readAllDates() {
        In in = new In();
        Queue<Date> queue = new Queue<Date>();
        while (!in.isEmpty()) {
            Date date = new Date(in.readString());
            queue.enqueue(date);
        }
        int n = queue.size();
        Date[] a = new Date[n];
        for (int i = 0; i < n; i++)
            a[i] = queue.dequeue();

        return a;
    }

    public static Transaction[] readAllTransactions() {
        In in = new In();
        Queue<Transaction> queue = new Queue<Transaction>();
        while (!in.isEmpty()) {
            Transaction transaction = new Transaction(in.readString());
            queue.enqueue(transaction);
        }
        int n = queue.size();
        Transaction[] a = new Transaction[n];
        for (int i = 0; i < n; i++)
            a[i] = queue.dequeue();

        return a;
    }


    public static void main(String[] args) {
        Date[] arrayDates = readAllDates();
        StdOut.println(arrayDates[0].toString());

    }
}
