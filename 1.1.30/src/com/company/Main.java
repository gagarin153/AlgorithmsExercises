package com.company;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.Arrays;

public class Main {

    //Array exercise. Write a code fragment that creates an n-by-n boolean array a[][] such that a[i][j] is true if i
    // and j a are relatively prime (have no common factors), and false otherwise.
    public static boolean cheackCommonFactors(int x, int y) {
        for (int i = 2; i <= y; i++) {
            if (x % i == 0 && y % i == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean[][] fillArray(boolean[][] a, int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 1 && j > 1 && i != j) {
                    if (i > j) {
                        a[i][j] = cheackCommonFactors(i, j);
                    } else {
                        a[i][j] = cheackCommonFactors(j, i);
                    }
                } else {
                    a[i][j] = true;
                }
            }
        }
        return a;
    }

    public static void outPutArray(boolean[][] a, int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                StdOut.print(a[i][j] + " ");
            }
            StdOut.print("\n");
        }
    }

    public static void main(String[] args) {

        int n = StdIn.readInt();
        boolean a[][] = new boolean[n][n];
        a = fillArray(a, n);
        outPutArray(a, n);

    }
}
