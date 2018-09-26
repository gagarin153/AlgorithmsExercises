package com.company;
/* A string s is a circular rotation of a string t if it matches when the characters
are circularly shifted by any number of positions; e.g., ACTGACG is a circular shift of
TGACGAC, and vice versa. Detecting this condition is important in the study of genomic
sequences. Write a program that checks whether two given strings s and t are circular
shifts of one another. Hint : The solution is a one-liner with indexOf(), length(), and
string concatenation. */

import edu.princeton.cs.algs4.StdOut;
import java.lang.String;


public class Main {

    public static void main(String[] args) {
        String s = "ACTGACG";
        String t = "TGACGAC";

        int count = 0;

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean x = true;
            while (x) {
                if (j != s.length() - 1) {
                    if (s.charAt(j) == t.charAt(i)) {
                        StdOut.println("s = " + s.charAt(j) + " " + s.charAt(j));
                        count++;
                        x = false;
                    } else {
                        x = true;
                    }
                    j++;
                } else {
                    j = 0;
                }
            }
        }
    }
}