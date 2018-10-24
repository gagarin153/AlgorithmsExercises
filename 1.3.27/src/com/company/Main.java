package com.company;

//Develop a recursive solution to the previous question.
//Write a method max() that takes a reference to the first node in a linked list as argument and returns the
// value of the maximum key in the list. Assume that all keys are positive integers, and return 0 if the list is empty.
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

class Node {
    int item;
    Node next;
}

public class Main {


    public static int max(Node first) {
        if (first == null) return 0;
        int max = first.item;
        for (Node x = first; x != null; x = x.next) {
            if (x.item > max) max = x.item;
        }
        return max;
    }

    public static void main(String[] args) {
        Node first = new Node();

        while (!StdIn.isEmpty()) {
            int item = StdIn.readInt();
            if (first == null) first.item = item;
            else {
                Node oldfirst = first;
                first = new Node();
                first.item = item;
                first.next = oldfirst;
            }
        }

        StdOut.println(max(first));
    }
}
