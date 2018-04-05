package com.company;


import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import java.util.ArrayList;
import java.util.List;

public class Main {
    // Add to the BinarySearch test client the ability to respond to a second argument:
    // + to print numbers from standsrd input that are not in the whitelist,
    // - to print numbers that  are in the whitelist

    public static int indexOf(int[] a, int key) {
        return indexOf(a, key, 0, a.length - 1);
    }

    public  static  int indexOf(int[] a, int key, int lo, int hi) {

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


    public static void checkItems(int[] a) {
        List<Integer> areInWhitelist = new ArrayList<Integer>();
        List<Integer> areNotInWhitelist = new ArrayList<Integer>();
            int startCycle = 1;
        while (startCycle == 1) {
            StdOut.println("Enter number");
            int number = StdIn.readInt();
            if (indexOf(a, number)  != -1 ){
                areInWhitelist.add(number);
            } else {
                areNotInWhitelist.add(number);
            }
            StdOut.println("Continue add numbers? 1/0");
            startCycle = StdIn.readInt();
        }


        StdOut.println("Select +/-\n1/0");
        int comand = StdIn.readInt();
        if(comand == 1) {
           for(int i = 0; i < areNotInWhitelist.size(); i++ ) {
              StdOut.println(areNotInWhitelist.get(i) + " ");
           }
        } else if (comand == 0) {
            for(int i = 0; i < areInWhitelist.size(); i++ ) {
                StdOut.println(areInWhitelist.get(i) + " ");
            }
        }


    }
    public static void main(String[] args) {

        int[] a = {1, 3, 5, 7};
        checkItems(a);

    }
}
