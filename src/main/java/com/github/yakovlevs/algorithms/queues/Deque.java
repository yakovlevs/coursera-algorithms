package com.github.yakovlevs.algorithms.queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<T> implements Iterable<T> {

  private Node first;
  private Node last;
  private int size;

  private class Node {
    T item;
    Node next;
    Node prev;
  }

  public Deque() {
  }

  public boolean isEmpty() {
    return size == 0;
  }


  public int size() {
    return size;
  }

  public void addFirst(T t) {
    validate(t);
    Node oldFirst = first;
    first = new Node();
    first.item = t;
    first.next = null;
    if (oldFirst == null) {
      first.prev = null;
      last = first;
    } else {
      first.prev = oldFirst;
      oldFirst.next = first;
    }
    size++;
  }


  public void addLast(T t) {
    validate(t);
    Node oldLast = last;
    last = new Node();
    last.item = t;
    last.prev = null;
    if (oldLast == null) {
      last.next = null;
      first = last;
    } else {
      last.next = oldLast;
      oldLast.prev = last;
    }
    size++;
  }

  private void validate(T t) {
    if (t == null) {
      throw new IllegalArgumentException();
    }
  }

  public T removeFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    T item = first.item;
    first = first.prev;
    if (first == null) {
      last = null;
    }
    size--;
    return item;
  }

  public T removeLast() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    T item = last.item;
    last = last.next;
    if (last == null) {
      first = null;
    }
    size--;
    return item;
  }

  private void remove(Node n) {

  }

  @Override
  public Iterator<T> iterator() {
    return new ListIterator();
  }

  private class ListIterator implements Iterator<T> {

    @Override
    public boolean hasNext() {
      return !isEmpty();
    }

    @Override
    public T next() {
      if (isEmpty()) {
        throw new NoSuchElementException();
      }
      return removeFirst();
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
