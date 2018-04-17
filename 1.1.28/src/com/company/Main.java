package com.company;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.Arrays;

public class Main {

    //Remove duplicates. Modify the test client in  BinarySearch to remove any duplicates keys int the whitelist after the sort.


    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static boolean contains(int[] a, int num) {
        for (int i : a) {
            if (i == num) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {


        int[] whitelist = StdIn.readAllInts();
        Arrays.sort(whitelist);
        int[] b = new int[whitelist.length - 1];
        int curIndex = 0;

        for (int i : whitelist) {
            if (!contains(b, i)) {
                b[curIndex++] = i;
            }
        }

        whitelist = Arrays.copyOf(b, curIndex);
        int key = StdIn.readInt();

        StdOut.println(indexOf(whitelist, key));

    }
}
