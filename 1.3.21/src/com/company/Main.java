package com.company;
// Write a method find() that takes a linked list and a string key as arguments and returns true if some node
// in the list has key as its item field, false otherwise.

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

class Node {
    String item;
    Node next;
}

public class Main {

    public  static boolean find(Node first, String key ) {
        boolean itFound = false;
        for (Node x = first; x != null; x = x.next)
           if (x.item == key) itFound = true;

        return itFound;
    }


    public static void main(String[] args) {
        Node first = new Node();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (first.item == null) first.item = item;
            else {
                Node oldfirst = first;
                first = new Node();
                first.item = item;
                first.next = oldfirst;
            }
        }

            StdOut.print(find(first, "6"));
    }
}
