package com.company;
/* Develop a class VisualCounter that allows both increment and decrement
operations. Take two arguments N and max in the constructor, where N specifies the
maximum number of operations and max specifies the maximum absolute value for
the counter. As a side effect, create a plot showing the value of the counter each time its
tally changes.
*/
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

class VisualCounter {
    private int count = 0;
    int x = 0;
    private int n;
    private double max;
    public VisualCounter(int n, double max) {
        this.max = max;
        this.n = n;

        StdDraw.setXscale(0, n);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(0.01);
    }
    public void increment() {
        count++;
        x++;
        StdDraw.point(x,count);
    }

    public void decrement() {
        x--;
        count--;
        StdDraw.point(x,count);
    }
}

public class TestVisualCounter {

    public static void main(String[] args) {
        int n = StdIn.readInt();
        VisualCounter c = new VisualCounter(n ,100);
        for(int i = 0; i < n; n++) {
            c.increment();
        }

    }
}
