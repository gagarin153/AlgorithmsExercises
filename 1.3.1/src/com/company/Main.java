package com.company;

//Add a method isFull() to FixedCapacityStackOfStrings.
  class FixedCapasityStack<Item> {
    private Item[] a;
    private int n;

    public FixedCapasityStack(int capasity) {
        a = (Item[]) new Object[capasity];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean isFull() {
        return n == a.length;
    }

    public int size() {
        return n;
    }

    public void push(Item item) {
        a[n++] = item;
    }
    public Item pop() {
        return a[--n];
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
