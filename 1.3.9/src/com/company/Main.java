package com.company;

/*1.3.9 Write a program that takes from standard input an expression without left parentheses and prints
the equivalent infix expression with the parentheses inserted. For example, given the input:
 1 + 2 ) * 3 - 4 ) * 5- 6 ) )
 your program should print
 ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) )
 */

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


public class Main {

    public static void main(String[] args) {
        Queue<String> q1 = new Queue<String>();
        Queue<String> q2 = new Queue<String>();
        boolean oldSymbolIsParentheses = false;
        int n = 1;
        int countParentheses = 0;
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (!s.equals(")")) {
                oldSymbolIsParentheses = false;
                q1.enqueue(s);
                n = 1;
            } else if (s.equals(")") && !oldSymbolIsParentheses) {
                q1.enqueue(s);
                for (int i = 0; !q1.isEmpty(); i++) {
                    s = q1.dequeue();
                    if (i == 0 && (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))) {
                        q2.enqueue(s);
                        q2.enqueue("(");
                    } else if (i == 0 && (!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/"))) {
                        q2.enqueue("(");
                        q2.enqueue(s);
                    } else {
                        q2.enqueue(s);
                    }
                }
                countParentheses++;
                oldSymbolIsParentheses = true;
            } else if (s.equals(")") && oldSymbolIsParentheses) {
                q2.enqueue(s);
                Queue<String> tmp = q2;
                q2 = q1;
                q1 = tmp;
                StdOut.println(countParentheses);
                int count = 0;
                while (!q1.isEmpty()) {
                    s = q1.dequeue();
                    if (s.equals("(")) count++;
                    if (s.equals("(") && (countParentheses - (2 * n - 1)) == count) {
                        q2.enqueue("(");
                        q2.enqueue(s);
                    } else q2.enqueue(s);
                }
                countParentheses++;
                n++;
            }
        }

        for (String q : q2) {
            StdOut.print(q + " ");
        }

    }
}

