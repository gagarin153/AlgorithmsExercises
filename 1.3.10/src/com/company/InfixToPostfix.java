package com.company;

/*Writea filter InfixToPostfix that converts an arithmetic expression from infix to postfix*/

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

public class InfixToPostfix {

    public static void main(String[] args) {
	    Stack<String> ops = new Stack<String>();
        Stack<String> vals = new Stack<String>();
        String finalExpression = "";
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("("));
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals(")")) {
                while (!vals.isEmpty()) {
                    finalExpression += vals.pop();
                }
                finalExpression += ops.pop();
            }
            else vals.push(s);
        }

        StdOut.println(finalExpression);
    }
}
