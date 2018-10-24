package com.company;
//Write a method removeAfter() that takes a linked-list Node as argument and removes
// the node following the given one (and does nothing if the argument or the next field in the argument node is null).

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


class Node {
    String item;
    Node next;
}

public class Main {

    public  static void removeAfter(Node node ) {
        node.next = null;
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

        removeAfter(first);
        StdOut.println(first.next);
    }
}