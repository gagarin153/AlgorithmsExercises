package com.company;

//Copy a queue.
// Create a new constructor so that Queue<Item> r = new Queue<Item>(q);
//makes r a reference to a new and independent copy of the queue q. You should be able to push and pop
// from either q or r without influencing the other. Hint : Delete all of the elements from q and
// add these elements to both q and r.


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

class Queue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int n;

    public Queue() {}
    public Queue( Queue q) {
        Item item;
        for(int i = 0; i < q.size(); i++) {
            item = (Item) q.dequeue();
            enqueue(item);
            q.enqueue(item);
        }

    }

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


public class Main {

    public static void main(String[] args) {

        Queue<String> q = new Queue<String>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            q.enqueue(s);
        }

        Queue<String> r = new Queue<String>(q);


        for(String s: r) {
            StdOut.print(s + " ");
        }
    }
}
