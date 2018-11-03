package com.company;

//Write a class RandomBag that implements this API. Note that this API is the same as for Bag, except for the adjective
// random, which indicates that the iteration should provide the items in random order
// (all N ! permutations equally likely, for each iterator).
// Hint : Put the items in an array and randomize their order in the iterator’s constructor.

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.Random;

import static edu.princeton.cs.algs4.StdRandom.shuffle;

class RandomBag<Item> implements Iterable<Item> {
    private Node first;
    private int n;

    private class Node {
        Item item;
        Node next;
    }

    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public Iterator<Item> iterator() {
        return new ListRandomIterator();
    }

    private class ListRandomIterator implements Iterator<Item> {
        Item[] a = toShuffleArray();
        int i = n - 1;

        private Item[] toShuffleArray() {
            int i = 0;
            Item[] a = (Item[]) new Object[n];
            for (Node x = first; x != null; x = x.next) {
                a[i] = x.item;
                i++;
            }
            StdRandom.shuffle(a);
            return a;
        }

        public boolean hasNext() {
            return i >= 0;
        }

        public Item next() {
            return a[i--];
        }

        public void remove() {
        }

    }
}

public class Main {

    public static void main(String[] args) {
        RandomBag<String> randomBag = new RandomBag<String>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            randomBag.add(s);
        }

        for (String s : randomBag) {
            StdOut.println(s);
        }
    }
}
