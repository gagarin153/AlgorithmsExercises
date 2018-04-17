package com.company;

import edu.princeton.cs.introcs.StdOut;
import java.util.ArrayList;

public class Main {

    // Write a version of BinarySearch that uses the recursive indexOf() given on page 25 and traces the method calls
    // Each time the recursive method is called, print the argument value lo and hi, indebted by the depth of recursion

    public static int indexOf(int[] a, int key) {
        return indexOf(a, key, 0, a.length - 1, 0);
    }

    public  static  int indexOf(int[] a, int key, int lo, int hi, int depth) {
        for(int i = 0; i < depth; i++) {
            StdOut.print('_');
        }
            StdOut.println("lo = " + lo + " " + "hi = " + hi);
        if (lo > hi)
            return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid])
            return indexOf(a, key, lo, mid - 1, depth + 1);
        else if (key > a[mid])
            return indexOf(a, key, mid + 1, hi, depth + 1);
        else
            return mid;

    }

    public static void main(String[] args) {

        int[] a = {-1000, 1, 2, 3, 4, 5, 8, 10};

        StdOut.println(indexOf(a, 8));
    }
}
