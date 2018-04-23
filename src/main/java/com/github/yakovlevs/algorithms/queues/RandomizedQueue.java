package com.github.yakovlevs.algorithms.queues;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<T> implements Iterable<T> {
  private Node first;
  private Node last;
  private int size;

  private class Node {
    T item;
    Node next;
  }

  public RandomizedQueue() {
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public void enqueue(T t) {
    if (t == null) {
      throw new IllegalArgumentException();
    }
    Node oldLast = last;
    last = new Node();
    last.item = t;
    last.next = null;
    if (isEmpty()) {
      first = last;
    } else {
      oldLast.next = last;
    }
    size++;
  }

  public T dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    StdRandom.setSeed(System.nanoTime());
    int i = StdRandom.uniform(size);
    Node node = first;
    T t = null;
    while (i > 1) {
      node = node.next;
      i--;
    }
    if (size == 1) {
      t = node.item;
      first = null;
      last = null;
    } else {
      t = node.next.item;
      node.next = node.next.next;
      if (node.next == null) {
        last = node;
      }
    }
    size--;
    return t;
  }

  public T sample() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    StdRandom.setSeed(System.nanoTime());
    int i = StdRandom.uniform(size);
    Node node = first;
    while (i > 0) {
      node = node.next;
      i--;
    }
    return node.item;
  }

  public Iterator<T> iterator() {
    return new RandomizedIterator();
  }

  private class RandomizedIterator implements Iterator<T> {

    @Override
    public boolean hasNext() {
      return !isEmpty();
    }

    @Override
    public T next() {
      if (isEmpty()) {
        throw new NoSuchElementException();
      }
      return dequeue();
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }

  public static void main(String[] args) {
    // unit testing (optional)
  }
}
