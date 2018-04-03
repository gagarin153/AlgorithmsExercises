package com.company;

import edu.princeton.cs.introcs.StdOut;

public class Main {

    // Write a version of BinarySearch that uses the recursive indexOf() given on page 25 and traces the method calls
    // Each time the recursive method is called, print the argument value lo and hi, indebted by the depth of recursion

    public static int indexOf(int[] a, int key) {
        return indexOf(a, key, 0, a.length - 1);
    }

    public  static  int indexOf(int[] a, int key, int lo, int hi) {
        StdOut.println("lo = " + lo + " " + "hi = " + hi);
        if (lo > hi)
            return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid])
            return indexOf(a, key, lo, mid - 1);
        else if (key > a[mid])
            return indexOf(a, key, mid + 1, hi);
        else
            return mid;

    }

    public static void main(String[] args) {

        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        StdOut.println(indexOf(a, 9));
    }
}
