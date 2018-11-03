package com.company;

 //Text editor buffer. Develop a data type for a buffer in a text editor that implements the following API:
//public class Buffer
//Buffer() create an empty buffer
//void insert(char c)  insert c at the cursor position
//char delete()  delete and return the character at the cursor move the cursor k positions to the left
// void left(int k) move the cursor k positions to the right number of characters in the buffer
// void right(int k)
//int size()
//Hint : Use two stacks.


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
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

class Buffer implements Iterable {
    private Stack<Character> beforeCursor = new Stack<Character>();
    private Stack<Character> afterCursor = new Stack<Character>();
    private int n = 0;

    public int size() {
        return n;
    }

    public void insert(char item) {
        beforeCursor.push(item);
        n++;
    }

    public char get() {
        char c = beforeCursor.pop();
        beforeCursor.push(c);
        return c;
    }

    public char delete() {
        char c = beforeCursor.pop();
        --n;
        return c;
    }

    public void left(int k) {
        for (int i = 0; i < k; i++) {
            afterCursor.push(beforeCursor.pop());
        }
    }

    public void right(int k) {
        for (int i = 0; i < k; i++) {
            beforeCursor.push(afterCursor.pop());
        }
    }

    public Iterator iterator() {
        return new ListIterator();
    }


    private class ListIterator implements Iterator {
        private char[] toArray() {
            char[] a = new char[n];
            int i;
            if (!afterCursor.isEmpty()) {
                i = afterCursor.size();
                for (char c : afterCursor) {
                    a[--i] = c;
                }
            }

            if (!beforeCursor.isEmpty()) {
                i = afterCursor.size();
                for (char c : beforeCursor) {
                    a[i] = c;
                    i++;
                }
            }

            return a;
        }

        char[] a = toArray();
        int i = n - 1;

        public boolean hasNext() {
            return i >= 0;
        }

        public void remove() {
        }

        public Object next() {
            return a[i--];
        }

    }
}

public class Main {

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        while (!StdIn.isEmpty()) {
            char c = StdIn.readChar();
            buffer.insert(c);
        }

        //  StdOut.println(buffer.get());
        //StdOut.println(buffer.delete());
        buffer.left(4);
        buffer.insert('A');
        buffer.right(2);
        buffer.insert('R');

        for (Object c : buffer) {
            StdOut.println(c);
        }
    }
}
