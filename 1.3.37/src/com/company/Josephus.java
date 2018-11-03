package com.company;

//Josephus problem. In the Josephus problem from antiquity, N people are in dire straits and agree to the
//following strategy to reduce the population. They arrange them- selves in a circle
//(at positions numbered from 0 to N–1) and proceed around the circle, eliminating every Mth person until
//only one person is left. Legend has it that Josephus figured out where to sit to avoid being eliminated.
//Write a Queue client Josephus that takes N and M from the command line and prints out the order in which
//people are eliminated (and thus would show Josephus where to sit in the circle).
//% java Josephus 7 2 135042 6
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

public class Josephus {

    public static void main(String[] args) {

        Queue<Integer> circle = new Queue<Integer>();
        int n = StdIn.readInt();
        int m = StdIn.readInt();
        int move = 1;


        for(int i = 0; i < n; i++) {
            circle.enqueue(i);
        }



        while(!circle.isEmpty()) {
            if (move > m) move = 1;
            int number = circle.dequeue();
            if(move == m) { StdOut.println(number); }
            else { circle.enqueue(number);}
            move++;
        }

    }
}
