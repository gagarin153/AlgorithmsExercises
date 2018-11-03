package com.company;
//Ring buffer. A ring buffer, or circular queue, is a FIFO data structure of a fixed size N. It is useful for
// transferring data between asynchronous processes or for storing log files. When the buffer is empty,
// the consumer waits until data is deposited; when the buffer is full, the producer waits to deposit data.
// Develop an API for a RingBuffer and an implementation that uses an array representation (with circular wrap-around).

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

class RingBuffer<Item>  {
    private int head;
    private int tail;
    Item[] a;

    public RingBuffer(int capacity) {
        a = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return head == (tail + 1) % a.length;
    }

    public void add(Item item) {
        a[tail++] = item;
        if (tail >= a.length) tail -= a.length;
    }

    public Item delete() {
        Item item = a[head];
        a[head++] = null;
        if (head >= a.length) head -= a.length;
        return item;
    }
}

public class Main {

    public static void main(String[] args) {
        RingBuffer<String> ringBuffer = new RingBuffer<String>(10);
	    while (!StdIn.isEmpty()) {
	        String s = StdIn.readString();
	        if (!s.equals("-")) {
                ringBuffer.add(s);
            } else {
                StdOut.println(ringBuffer.delete());
            }
        }
    }
}
