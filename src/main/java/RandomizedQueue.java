import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
  private Node first;
  private Node last;
  private int size;

  private class Node {
    Item item;
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

  public void enqueue(Item item) {
    if (item == null) {
      throw new IllegalArgumentException();
    }
    Node oldLast = last;
    last = new Node();
    last.item = item;
    last.next = null;
    if (isEmpty()) {
      first = last;
    } else {
      oldLast.next = last;
    }
    size++;
  }

  public Item dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    int i = StdRandom.uniform(size);
    Node node = first;
    Item item = null;
    while (i > 1) {
      node = node.next;
      i--;
    }
    if (size == 1) {
      item = node.item;
      first = null;
      last = null;
    } else {
      item = node.next.item;
      node.next = node.next.next;
      if (node.next == null) {
        last = node;
      }
    }
    size--;
    return item;
  }

  public Item sample() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    int i = StdRandom.uniform(size);
    Node node = first;
    while (i > 0) {
      node = node.next;
      i--;
    }
    return node.item;
  }

  public Iterator<Item> iterator() {
    return new RandomizedIterator();
  }

  private class RandomizedIterator implements Iterator<Item> {

    @Override
    public boolean hasNext() {
      return !isEmpty();
    }

    @Override
    public Item next() {
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
