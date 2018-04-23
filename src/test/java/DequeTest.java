import org.ehcache.sizeof.SizeOf;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class DequeTest {

  @Test
  public void isEmpty() {
    Deque<Integer> deque = new Deque<Integer>();
    deque.addFirst(1);
    deque.removeFirst();
  }

  @Test
  public void size() {
    Deque<Integer> integers = new Deque<>();
    assertEquals(0, integers.size());
    integers.addFirst(1);
    assertEquals(1, integers.size());
    integers.removeLast();
    assertEquals(0, integers.size());
  }

  @Test(expected = java.lang.IllegalArgumentException.class)
  public void addFirstCornerCases() {
    Deque<String> strings = new Deque<>();
    strings.addLast(null);
  }

  @Test(expected = java.lang.IllegalArgumentException.class)
  public void addLastCornerCases() {
    Deque<String> strings = new Deque<>();
    strings.addFirst(null);
  }

  @Test
  public void removeFirst() {
    Deque<String> strings = new Deque<>();
    strings.addFirst("A");
    strings.addFirst("B");
    strings.addFirst("C");
    strings.addFirst("D");
    strings.removeFirst();
    strings.removeFirst();
    strings.removeFirst();
    strings.removeFirst();
    assertTrue(strings.isEmpty());
  }

  @Test(expected = java.util.NoSuchElementException.class)
  public void removeFirstCornerCases() {
    Deque<String> strings = new Deque<>();
    strings.removeFirst();
  }

  @Test
  public void removeLast() {
    Deque<String> strings = new Deque<>();
    strings.addLast("A");
    strings.addFirst("B");
    strings.addLast("C");
    strings.addFirst("D");

    System.out.println(strings.removeLast());
    System.out.println(strings.removeFirst());
    System.out.println(strings.removeLast());
    System.out.println(strings.removeFirst());
    assertTrue(strings.isEmpty());
  }

  @Test(expected = java.util.NoSuchElementException.class)
  public void removeLastCornerCases() {
    Deque<String> strings = new Deque<>();
    strings.removeLast();
  }

  public void memory(String message, int n) {
    Deque<Integer> integers = new Deque<>();
    SizeOf sizeOf = SizeOf.newInstance();
    System.out.println("only deque size: " + sizeOf.sizeOf(integers));
    long shallowSize = 0;
    for (int i = 0; i < n; i++) {
      Integer integer = i;
      shallowSize += sizeOf.sizeOf(i);
      integers.addFirst(i);
    }

    System.out.println(message + " " + shallowSize / n);
  }

  @Test
  public void iterator() {
    Deque<Integer> integers = new Deque<>();
    integers.addFirst(0);
    integers.addFirst(1);
    Iterator<Integer> iterator = integers.iterator();
    Iterator<Integer> iterator1 = integers.iterator();
    System.out.println(iterator.next());
    System.out.println(iterator1.next());
  }

  @Test
  public void memory10k() {
    memory("10k:", 10_000);
  }

  @Test
  public void memory1kk() {
    memory("1kk:", 1_000_000);
  }

  @Ignore
  @Test
  public void memory10kk() {
    memory("10kk:", 10_000_000);
  }
}