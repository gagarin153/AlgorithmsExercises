package com.company;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;



class DoublyLinkedList<Item> {

    DoubleNode first;

    private static class DoubleNode<Item> {
        Item item;
        DoubleNode next;
        DoubleNode previous;

    }
}

public class Main {

    static class DoubleNode {
        String item;
        DoubleNode next;
        DoubleNode previous;

        public static void insertInStart(DoubleNode first, String item) {
            DoubleNode oldFirst = first;
            first = new DoubleNode();
            first.item = item;
            first.next = oldFirst;
            oldFirst.previous = first;
        }
    }


//    public void insertInStart(DoubleNode first, String item) {
//        DoubleNode oldFirst = first;
//        first = new DoubleNode();
//        first.item = item;
//        first.next = oldFirst;
//        oldFirst.previous = first;
//    }


    public static void main(String[] args) {
	    DoubleNode first = new DoubleNode();

	    while (!StdIn.isEmpty()) {
	        String s = StdIn.readString();
	        DoubleNode.insertInStart(first, s);
        }

        for(DoubleNode x = first; x != null; x = x.next) {
            StdOut.println(x.item);
        }
    }
}
