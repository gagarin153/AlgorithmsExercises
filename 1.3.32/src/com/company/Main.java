package com.company;

//Steque. A stack-ended queue or steque is a data type that supports push, pop, and enqueue.
// Articulate an API for this ADT. Develop a linked-list-based implementation.
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;


class Steque<Item> implements Iterable<Item> {
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

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        if (last == null) last = first;
        n++;
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


    public Item pop() {
        Item item = first.item;
        first = first.next;
        n--;
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

public class Main {


    public static void main(String[] args) {

        Steque<String> steque = new Steque<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            steque.push(s);
            steque.enqueue(s + "\"");


        }

        for (String i : steque) {
            StdOut.println(i + " ");
        }

    }
}
