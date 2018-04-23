package com.github.yakovlevs.algorithms.queues;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueueTest {
  @Test
  public void isEmpty() {
  }

  @Test
  public void size() {
  }

  @Test
  public void enqueue() {
    RandomizedQueue<String> strings = new RandomizedQueue<>();
    strings.enqueue("A");
    strings.enqueue("B");
    strings.enqueue("C");
  }

  @Test(expected = IllegalArgumentException.class)
  public void enqueueCornerCases() {
    RandomizedQueue<String> strings = new RandomizedQueue<>();
    strings.enqueue(null);
  }

  @Test
  public void dequeue() {
    RandomizedQueue<String> strings = new RandomizedQueue<>();
    strings.enqueue("A");
    System.out.println(strings.dequeue());
    strings.enqueue("B");
    System.out.println(strings.dequeue());
    strings.enqueue("C");
    strings.enqueue("D");
    System.out.println(strings.dequeue());
    System.out.println(strings.dequeue());
    strings.enqueue("E");
    System.out.println(strings.dequeue());
  }

  @Test(expected = NoSuchElementException.class)
  public void dequeueCornerCases() {
    RandomizedQueue<String> strings = new RandomizedQueue<>();
    strings.dequeue();
  }

  @Test
  public void sample() {
    RandomizedQueue<String> strings = new RandomizedQueue<>();
    strings.enqueue("A");
    strings.enqueue("B");
    strings.enqueue("C");
    strings.enqueue("D");
    strings.enqueue("E");
    strings.enqueue("F");
    for (int i = 0; i < 100; i++) {
      System.out.println(strings.sample());
    }
  }

  @Test(expected = NoSuchElementException.class)
  public void sampleCornerCases() {
    RandomizedQueue<String> strings = new RandomizedQueue<>();
    strings.sample();
  }

  @Test
  public void iterator() {
    it();
    System.out.println("");
    it();
  }

  private void it() {
    RandomizedQueue<String> strings = new RandomizedQueue<>();
    strings.enqueue("A");
    strings.enqueue("B");
    strings.enqueue("C");
    strings.enqueue("D");
    strings.enqueue("E");
    strings.enqueue("F");
    Iterator<String> iterator = strings.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}

