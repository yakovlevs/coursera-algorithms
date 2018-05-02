package com.github.yakovlevs.algorithms.queues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
  public static void main(String[] args) {
    RandomizedQueue<String> strings = new RandomizedQueue<>();
    while (!StdIn.isEmpty()) {
      String s = StdIn.readString();
      strings.enqueue(s);
    }
    for (int i = 0; i < Integer.parseInt(args[0]); i++) {
      StdOut.println(strings.dequeue());
    }
  }
}
