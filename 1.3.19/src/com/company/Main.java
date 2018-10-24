package com.company;

//Give a code fragment that removes the last node in a linked list whose first node is first.

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

class Node {
    String item;
    Node next;
}

public class Main {

    public static void main(String[] args) {
        Node first = new Node();
        Node previous = new Node();
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

        for( Node x = first; x != null; x = x.next) {
            if ( x.next == null) {
                x = previous;
                previous.next = null;
            }
            previous = x;
        }

        for( Node x = first; x != null; x = x.next) {
            StdOut.println(x.item);
        }
    }
}
