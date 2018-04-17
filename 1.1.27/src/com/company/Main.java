package com.company;

import edu.princeton.cs.introcs.StdOut;

public class Main {

    //binomial distribution. Estimate the number of recursive calls that would be used by the code to compute binominal(100, 50, 0.25)
    //Develop a better implementation that is based on saving computed values in an array


//    public static double binomial(int n, int k, double p) {
//        if ((n == 0) && (k == 0)) return 1.0;
//        if ((n < 0) || (k < 0)) return 0.0;
//        return (1 - p)*binomial(n -1, k, p) + p*binomial(n - 1, k - 1, p);
//    }


    public static double[][] cache = new double[101][51];

    public static double binomial(int n, int k, double p) {
        if ((n == 0) && (k == 0)) return 1.0;
        if ((n < 0) || (k < 0)) return 0.0;
        if (cache[n][k] != 0) {
            return cache[n][k];
        }
        cache[n][k] = (1 - p)*binomial(n - 1, k, p) + p*binomial(n - 1, k - 1, p);
        return cache[n][k];
    }

    public static void main(String[] args) {
        StdOut.println(binomial(100,50, 0.25));
    }


}
