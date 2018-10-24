package com.company;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


class Node {
    String item;
    Node next;
}

public class Main {

    public  static void insertAfter(Node node1, Node node2 ) {
        if (node1 == null || node2 == null) return;
        node1.next = node2;
    }


    public static void main(String[] args) {
        Node first = new Node();
        Node node = new Node();
        node.item = "dwedw";
        node.next = null;
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

        insertAfter(first, node);
        StdOut.println(first.next.item);
    }
}