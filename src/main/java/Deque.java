import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

  private Node first;
  private Node last;
  private int size;

  private class Node {
    Item item;
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

  public void addFirst(Item item) {
    validate(item);
    Node oldFirst = first;
    first = new Node();
    first.item = item;
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

  public void addLast(Item item) {
    validate(item);
    Node oldLast = last;
    last = new Node();
    last.item = item;
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

  private void validate(Item item) {
    if (item == null) {
      throw new IllegalArgumentException();
    }
  }

  public Item removeFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    Item item = first.item;
    first = first.prev;
    if (first == null) {
      last = null;
    }
    size--;
    return item;
  }

  public Item removeLast() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    Item item = last.item;
    last = last.next;
    if (last == null) {
      first = null;
    }
    size--;
    return item;
  }

  @Override
  public Iterator<Item> iterator() {
    return new ListIterator();
  }

  private class ListIterator implements Iterator<Item> {

    @Override
    public boolean hasNext() {
      return !isEmpty();
    }

    @Override
    public Item next() {
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
