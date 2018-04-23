package com.github.yakovlevs.algorithms.queues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
  public static void main(String[] args) {
    RandomizedQueue<String> strings = new RandomizedQueue<>();
    while (!StdIn.isEmpty()) {
      String s = StdIn.readString();
      if (s.equals("")) break;
      strings.enqueue(s);
    }
    for (int i = 0; i < Integer.valueOf(args[0]); i++) {
      System.out.println(strings.dequeue());
    }
  }
}
