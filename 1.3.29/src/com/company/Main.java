package com.company;

//Write a Queue implementation that uses a circular linkedlist, which is the same as a linked list except that no
// links are null and the value of last.next is first whenever the list is not empty. Keep only one Node instance
// variable (last)
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

class Queue<Item> implements Iterable<Item> {
    private Node last;
    private int n;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return last == null;
    }

    public int size() {
        return n;
    }

    public void enqueue(Item item) {

       Node oldlast = last;
       last = new Node();
       last.item = item;
       if (oldlast == null) last.next = last;
       else {
           last.next = oldlast.next;
           oldlast.next = last;
       }
        n++;
    }

    public Item dequeue() {
        Item item = last.next.item;
        last.next = last.next.next;
        n--;
        if(size() == 0) last = null;
        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = last.next;
        private int n = 0;

        public boolean hasNext() {
            return size() != n;
        }

        public void remove() {
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            n++;
            return item;
        }

    }
}




public class Main {

    public static void main(String[] args) {

        Queue<String> queue = new Queue<String>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            queue.enqueue(s);
        }

        for(String s: queue) {
            StdOut.println(s);
        }

    }
}
