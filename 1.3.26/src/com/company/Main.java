package com.company;
//Write a method remove() that takes a linked list and a string key as arguments and removes all
// of the nodes in the list that have key as its item field.

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

class Node {
    String item;
    Node next;
}

public class Main {


    public static Node remove(String key, Node first) {
        Node last = new Node();
        Node newfirst = last;
        for (Node x = first; x != null; x = x.next) {
            if (!x.item.equals(key)) {
                Node oldlast = last;
                last = new Node();
                last.item = x.item;
                last.next = null;
                if (newfirst.item == null) newfirst = last;
                else oldlast.next = last;
            }
        }
        return newfirst;
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

        first = remove("5", first);

        for (Node x = first; x != null; x = x.next) {
            StdOut.print(x.item + " ");
        }
    }
}
