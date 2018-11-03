package com.company;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

class Stack<Item> implements Iterable<Item> {
    private Node first;
    private int n;

    public Stack() {}

    public Stack(Stack s) {
        Node last = new Node();
        for(Object item: s) {
            Node oldlast = last;
            last = new Node();
            last.item = (Item) item;
            last.next = null;
            if (isEmpty()) first = last;
            else oldlast.next = last;
            n++;
        }
    }

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public  int size() {
        return n;
    }

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
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

    private  class ListIterator implements Iterator<Item> {
        private Node current = first;

        public  boolean hasNext() {
            return current != null;
        }

        public void remove() {};

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

    }
}

public class Main {

    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            s.push(item);
        }

        Stack<String> t = new Stack<String>(s);


        for(String item: t) {
            StdOut.print(item + " ");
        }
    }
}
