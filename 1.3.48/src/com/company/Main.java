package com.company;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


import java.util.Iterator;

class Stack<Item> implements Iterable<Item> {
    private Node first;
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

class Deque<Item> implements Iterable<Item> {
    private Stack<Item> leftstack = new Stack<Item>();
    private Stack<Item> rightstack = new Stack<Item>();
    private int n = 0;

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void pushLeft(Item item) {
        leftstack.push(item);
        n++;
    }

    public void pushRight(Item item) {
        if(!leftstack.isEmpty()) leftstack.push(item);
        else rightstack.push(item);
        n++;
    }

    public Item popLeft(String s) {
        n--;
        if(!leftstack.isEmpty()) return leftstack.pop();
        rightstack
    }

    public Item popRight() {
        n--;
        return rightstack.pop();
    }


    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator {
        private Item[] toArray() {
            Item[] a = (Item[]) new Object[n];
            int i;
            if (!leftstack.isEmpty()) {
                i = 0;
                for (Item item : leftstack) {
                    a[i++] = item;
                }
            }

            if (!rightstack.isEmpty()) {
                i = leftstack.size();
                for (Item item : rightstack) {
                    a[i++] = item;
                }
            }

            return a;
        }

        Item[] a = toArray();
        int i = n - 1;

        public boolean hasNext() {
            return i >= 0;
        }

        public void remove() {
        }


        public Item next() {
            return a[i--];
        }

    }
}


public class Main {

    public static void main(String[] args) {
        Deque<String> deque = new Deque<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            deque.pushRight(s);
            deque.pushLeft(s);
        }

        for (String s : deque) {
            StdOut.print(s + " ");
        }
    }
}