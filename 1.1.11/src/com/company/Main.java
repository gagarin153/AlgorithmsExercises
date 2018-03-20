package com.company;

import edu.princeton.cs.introcs.StdOut;
//Write code fragment to print the contents of two-dimensional boolean array, using * to represent  true a a space to represent false

public class Main {

    public static void main(String[] args) {

        boolean[][] matrix = {{false, true, false}, {true, false, true}};

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++)
                if (matrix[i][j] == true)
                    StdOut.print("*");
                else
                    StdOut.print(" ");
            StdOut.println();
        }

    }
}
