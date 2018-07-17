package com.company;

//  Matrix library. Write a library Matrix that implements the following API:
// static double dot(double[] x, double[] y)
//static double[][] mult(double[][] a, double[][] b)
//static double[][] transpose(double[][] a)
//static double[] mult(double[][] a, double[] x)
//static double[][] mult(double[] y, double[][] a)

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;


class Matrix {

    static double dot(double[] x, double[] y) {
        double dot = 0;
        for (int i = 0; i < x.length; i++) {
            dot += x[i] * y[i];
        }
        return dot;
    }


    static double[][] mult(double[][] a, double[][] b) {
        double[][] c = new double[a.length][b[0].length];
        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < b.length; j++) {
                for (int k = 0; k < b.length; k++)
                    c[i][j] += a[i][k] * b[k][j];
            }
        }
        return c;
    }

    static double[] mult(double[] y, double[][] a) {
        double[] c = new double[y.length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++)
                c[i] += y[j] * a[j][i];
        }
        return c;
    }

    static double[][] mult(double[][] a, double[] y) {
        double[][] c = new double[a.length][1];
        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < y.length; j++) {
                c[i][0] += a[i][j] * y[j];
            }
        }
        return c;
    }

    static double[][] transpose(double[][] a) {
        double[][] c = new double[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                c[j][i] = a[i][j];
            }
        }
        return c;
    }

}

public class Main {

    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        double[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] b = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[] x = {1, 2, 3};
        double[] y = {1, 2, 3};
        double[][] c;
        double[] e;


        StdOut.print("Dot product\n");
        StdOut.print(matrix.dot(x, y) + "\n");

        StdOut.print("a * b\n");
        c = matrix.mult(a, b);
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                StdOut.print(c[i][j] + " ");
            }
            StdOut.print("\n");
        }


        StdOut.print("x * a\n");
        e = matrix.mult(x, a);
        for (int i = 0; i < e.length; i++) {
            StdOut.print(e[i] + " ");
        }
        StdOut.print("\n");


        StdOut.print("a * x\n");
        c = matrix.mult(a, x);
        for (int i = 0; i < c.length; i++) {
            StdOut.print(c[i][0] + "\n");
        }

        StdOut.print("transpose a\n");
        c = matrix.transpose(a);
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                StdOut.print(c[i][j] + " ");
            }
            StdOut.print("\n");
        }
    }
}
