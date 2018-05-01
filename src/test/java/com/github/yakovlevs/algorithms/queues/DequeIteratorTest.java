package com.github.yakovlevs.algorithms.queues;

import com.github.yakovlevs.algorithms.queues.Deque;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class DequeIteratorTest {

  @Test
  public void iterator() {
    Iterator<Integer> iterator = new Deque<Integer>().iterator();
    assertTrue(!iterator.hasNext());
  }

  @Test
  public void iteratorHasNext() {
    Iterator<Integer> iterator = new Deque<Integer>().iterator();
    assertTrue(!iterator.hasNext());
  }

  @Test(expected = java.util.NoSuchElementException.class)
  public void nextCornerCases() {
    Iterator<Integer> iterator = new Deque<Integer>().iterator();
    iterator.next();
  }

  @Test(expected = java.lang.UnsupportedOperationException.class)
  public void remove() {
    Iterator<Integer> iterator = new Deque<Integer>().iterator();
    iterator.remove();
  }
}