package com.company;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.Queue;

class GeneralizedQueue<Item> implements Iterable<Item> {
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

    public void insert(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        n++;
    }

    public Item delete(int k) {
        Item item = first.item;
        Node newfirst = null;
        Node newlast = null;
        int i = 0;
        for (Node x = first; x != null; x = x.next) {
            if (i != k - 1) {
                Node oldlast = newlast;
                newlast = new Node();
                newlast.item = x.item;
                newlast.next = null;
                if (newfirst == null) newfirst = newlast;
                else oldlast.next = newlast;
            } else {
                item = x.item;
            }
            i++;
        }
        first = newfirst;
        --n;
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

public class GeneralizedQueueTest {

    public static void main(String[] args) {
        GeneralizedQueue<String> generalizedQueue = new GeneralizedQueue<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            generalizedQueue.insert(s);
        }
        StdOut.println("Delete: " + generalizedQueue.delete(1) + "\n");
        for (String s : generalizedQueue) {
            StdOut.println(s);
        }
    }
}
