package com.company;

//Write a method delete() that takes an int argument k and deletes the kth element in a linked list, if it exists.

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

class Node {
    String item;
    Node next;
}

public class Main {


    public static Node delete(int k, Node first) {
        int i = 0;
        Node last = new Node();
        Node newfirst = last;
        for (Node x = first; x != null; x = x.next) {
            if (i != k) {
                Node oldlast = last;
                last = new Node();
                last.item = x.item;
                last.next = null;
                if (newfirst.item == null) newfirst = last;
                else oldlast.next = last;
            }
            i++;
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

       first = delete(5, first);

        for (Node x = first; x != null; x = x.next) {
            StdOut.print(x.item + " ");
        }
    }
}
