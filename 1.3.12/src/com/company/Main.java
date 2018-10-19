package com.company;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/*WriteaniterableStackclientthathasastaticmethodcopy()thattakesastack of strings as argument and returns a
copy of the stack.  Note: This ability is a prime example of the value of having an iterator, because
it allows development of  such functionality without changing the basic API.*/

class Stack<Item> implements  Iterable<Item> {
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


public class Main {

    public static Stack<String> copy (Stack<String> originalStack) {
        Stack<String> copiedStack1 = new Stack<String>();
        Stack<String> copiedStack2 = new Stack<String>();
        for(String s: originalStack) {
            copiedStack1.push(s);
        }
        while (!copiedStack1.isEmpty()) {
            String s = copiedStack1.pop();
            copiedStack2.push(s);
        }
        return copiedStack2;
    }


    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
         while (!StdIn.isEmpty()) {
             String s = StdIn.readString();
             stack.push(s);
         }

        Stack<String> copiedStack = copy(stack);

        for(String s: copiedStack) {
            StdOut.println(s);
        }

    }
}
