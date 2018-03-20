package com.company;

public class Main {

    //write a static method lg() that takes an int value n as argument and returns the largest int not larger than the base 2 logarithm of n. Do not use Math
    public static int lg(int n) {
        int pow = 0;
        while (n > 1) {
            n /= 2;
            pow++;
        }
        return pow;
    }

    public static void main(String[] args) {

        System.out.print(lg(1));
    }
}

