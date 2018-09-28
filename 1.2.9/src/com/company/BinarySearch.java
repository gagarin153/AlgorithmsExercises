package com.company;

/*  Instrument BinarySearch (page 47) to use a Counter to count the total number
of keys examined during all searches and then print the total after all searches are complete.
Hint : Create a Counter in main() and pass it as an argument to rank().
*/
import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


import java.util.Arrays;

import static edu.princeton.cs.algs4.StdIn.*;

public class BinarySearch {

    public static int indexOf(int[] a, int key, Counter examinedKeys) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            examinedKeys.increment();
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        // In in = new In(args[0]);
        int[] whitelist = {1, 2, 3, 4, 5, 6, 7, 8};//StdIn.readAllInts();
        Arrays.sort(whitelist);

        Counter examinedKeys = new Counter("examinedKeys");
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (indexOf(whitelist, key, examinedKeys) == -1) {
                StdOut.println(key);
            }
        }
        StdOut.println(examinedKeys.toString());
    }
}
