package com.company;

/*Write a program EvaluatePostfix that takes a postfix expression from stan- dard input, evaluates it,
        and prints the value. (Piping the output of your program from the previous exercise to this
        program gives equivalent behavior to Evaluate.
*/

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

        ;

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

    }
}

public class EvaluatePostfix {

    public static void main(String[] args) {
        Stack<Double> vals = new Stack<Double>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("+") || s.equals("+") || s.equals("*") || s.equals("/")) {
                Double v = vals.pop();

                if (s.equals("+")) v = vals.pop() + v;
                else if (s.equals("-")) v = vals.pop() - v;
                else if (s.equals("*")) v = vals.pop() * v;
                else if (s.equals("/")) v = vals.pop() / v;
                vals.push(v);
            } else vals.push(Double.parseDouble(s));
        }
        StdOut.println(vals.pop());
    }
}
