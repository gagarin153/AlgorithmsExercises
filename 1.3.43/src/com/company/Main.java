package com.company;

import edu.princeton.cs.algs4.StdOut;
import java.io.File;

 //Listing files. A folder is a list of files and folders. Write a program that takes the name of a folder as
// a command-line argument and prints out all of the files contained in that folder,
// with the contents of each folder recursively listed (indented) under that folder’s name.
// Hint : Use a queue, and see java.io.File.



import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

class Queue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int n;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        n++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;
        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

    }
}

public class Main {

    public static void processFilesFromFolder(File folder, int countTab)
    {
        Queue<File> folderEntries = new Queue<File>();
        for(File entry: folder.listFiles()) {
            folderEntries.enqueue(entry);
        }

        countTab++;
        StdOut.println(folder.getName());

        for (File entry: folderEntries)
        {
            if (entry.isDirectory())
            {
                processFilesFromFolder(entry, countTab);
                continue;
            }
            for(int i = 0; i < countTab; i++) {
                StdOut.print("  ");
            }
            StdOut.println(entry.getName());
        }
    }

    public static void main(String[] args) {
        String path = "/Users/newaccount/Desktop/Файлы/Видео материал ";
        File folder = new File(path);

        processFilesFromFolder(folder, 0);
    }
}
