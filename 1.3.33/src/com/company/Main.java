package com.company;


//Deque. A double-ended queue or deque (pronounced “deck”) is like a stack or a queue but supports adding
//and removing items at both ends. A deque stores a collec- tion of items and supports the following API:
//public class Deque<Item> implements Iterable<Item>
//Deque()
// boolean isEmpty()
//int size()
//void pushLeft(Item item)
// void pushRight(Item item) Item popLeft()
//Item popLeft()
//Item popRight()
//Write a class Deque that uses a doubly-linked list to implement this API
// and a class ResizingArrayDeque that uses a resizing array

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

class Deque<Item> implements Iterable<Item> {
    private DoubleNode leftend;
    private DoubleNode rightend;
    private int n;

    private class DoubleNode {
        Item item;
        DoubleNode next;
        DoubleNode previous;
    }

    public boolean isEmpty() {
        return leftend == null;
    }

    public int size() {
        return n;
    }

    public void pushLeft(Item item) {
        DoubleNode oldleftend = leftend;
        leftend = new DoubleNode();
        leftend.item = item;
        leftend.next = oldleftend;
        leftend.previous = null;
        if (rightend == null) rightend = leftend;
        else oldleftend.previous = leftend;
        n++;
    }

    public void pushRight(Item item) {
        DoubleNode oldrightend = rightend;
        rightend = new DoubleNode();
        rightend.item = item;
        rightend.next = null;
        rightend.previous = oldrightend;
        if (isEmpty()) leftend = rightend;
        else oldrightend.next = rightend;
        n++;

    }


    public Item popLeft() {
        Item item = leftend.item;
        leftend = leftend.next;
        leftend.previous = null;
        n--;
        return item;
    }

    public Item popRight() {
        Item item = rightend.item;
        rightend = rightend.previous;
        rightend.next = null;
        n--;
        return item;
    }


    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private DoubleNode current = leftend;

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


class ResizingArrayDeque<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1];
    private int n;

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < n; i++)
            temp[i] = a[i];
        a = temp;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void pushLeft(Item item) {
        if (n == a.length) resize(2 * a.length);
        a[n++] = item;
    }

    public void pushRight(Item item) {
        if (n == a.length) resize(2 * a.length);
        Item oldvalue = a[0];
        for (int i = 1; i < n + 1; i++) {
           Item temp = a[i];
           a[i] = oldvalue;
           oldvalue = temp;
        }
        a[0] = item;
        n++;
    }


    public Item popLeft() {
        Item item = a[--n];
        a[n] = null;
        if (n > 0 && n == a.length / 4) resize(a.length / 2);
        return item;
    }

    public Item popRight() {
        Item item = a[0];
        for (int i = 0; i < n - 1; i++)
            a[i] = a[i + 1];
        n--;
        if (n > 0 && n == a.length / 4) resize(a.length / 2);
        return item;
    }


    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private int i = n - 1;

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
        Deque<Integer> deque = new Deque<Integer>();
        ResizingArrayDeque<Integer> resizingArrayDeque = new ResizingArrayDeque<Integer>();
        for (int i = 0; i < 10; i++) {
            deque.pushLeft(i);
            deque.pushRight(i);
            resizingArrayDeque.pushLeft(i);
            resizingArrayDeque.pushRight(i);
        }

        StdOut.println("deque: ");
        for (int item : deque) {
            StdOut.print(item + " ");
        }


        StdOut.println("\nresizingArrayDeque");

        for (int item : resizingArrayDeque) {
            StdOut.print(item + " ");
        }

        StdOut.println("\ndeque: ");

        for (int i = 0; i < 5; i++) {
            StdOut.print(deque.popLeft() + " ");
        }

        StdOut.println("\ndeque: ");
        for (int i = 0; i < 5; i++) {
            StdOut.print(deque.popRight() + " ");
        }


        StdOut.println("\nresizingArrayDeque");

        for (int i = 0; i < 5; i++) {
            StdOut.print(resizingArrayDeque.popLeft() + " ");
        }

        StdOut.println("\nresizingArrayDeque");

        for (int i = 0; i < 5; i++) {
            StdOut.print(resizingArrayDeque.popRight() + " ");
        }

        StdOut.println("\ndeque: ");

        for (int item : deque) {
            StdOut.print(item + " ");
        }

        StdOut.println("\nresizingArrayDeque");

        for (int item : resizingArrayDeque) {
            StdOut.print(item + " ");
        }

    }
}
