package com.company;

//Move-to-front. Read in a sequence of characters from standard input and maintain the characters in a linked
// list with no duplicates. When you read in a previ- ously unseen character, insert it at the front of the list.
// When you read in a duplicate character, delete it from the list and reinsert it at the beginning. Name your
// program MoveToFront: it implements the well-known move-to-front strategy, which is useful for caching, data
// compression, and many other applications where items that have been recently accessed are more likely to be
// reaccessed.


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MoveToFront {


    static class Node {
        String item;
        Node next;
    }

    public static void add(Node first, String s) {
        Node copyfirst = null;
        Node last = null;
        if (first.item != null) {
            for (Node x = first; x != null; x = x.next) {
                if (!s.equals(x.item)) {
                    Node oldlast = last;
                    last = new Node();
                    last.item = x.item;
                    last.next = null;
                    if (copyfirst == null) copyfirst = last;
                    else oldlast.next = last;
                }
            }
       }
        first.item = s;
        first.next = copyfirst;
    }

    public static void main(String[] args) {
        Node first = new Node();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            add(first, s);
        }

        for(Node x = first; x != null; x = x.next) {
            StdOut.print(x.item + " ");
        }
    }
}
