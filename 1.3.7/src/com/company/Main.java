package com.company;
/*Add a method peek() to Stack that returns the most recently inserted item on
the stack (without popping it).*/

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

    public Item peek() {
        return first.item;
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

    public static void main(String[] args) {
	// write your code here
    }
}
