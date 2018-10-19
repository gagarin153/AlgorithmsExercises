package com.company;

/*Write a stack client Parentheses that reads in a text stream from standard input
        and uses a stack to determine whether its parentheses are properly balanced. For example,
        your program should print true for [()]{}{[()()]()} and false for [(]).*/
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

public class Parentheses {


    public static void main(String[] args) {
        boolean x = true;
        Stack<String> parentheses = new Stack<String>();
	    while (!StdIn.isEmpty()) {
	        String s = StdIn.readLine();
	        if (s.equals("[") || s.equals("{") || s.equals("(")) {
                parentheses.push(s);
            } else if (s.equals("]") ) {
	            if(!parentheses.pop().equals("[")) {
	                x = false;
                }
            } else if (s.equals("}") ) {
                if(!parentheses.pop().equals("{")) {
                    x = false;
                }
            } else if (s.equals(")")) {
                if(!parentheses.pop().equals("(")) {
                    x = false;
                }
            }
        }
        StdOut.println(x);

    }
}
