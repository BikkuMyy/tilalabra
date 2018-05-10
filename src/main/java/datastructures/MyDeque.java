package datastructures;

import java.util.*;

public class MyDeque<E> implements Deque<E> {
  private Object[] queue;
  private int head;
  private int tail;

  public MyDeque() {
    queue = new Object[16];
  }

  @Override
  public boolean isEmpty() {
    return head == tail;
  }

  @Override
  public void push(E newElement) {
    queue[head = (head - 1) & (queue.length - 1)] = newElement;
    if (head == tail) {
      doubleCapacity();
    }
  }

  // pollFirst
  @Override
  public E pop() {
    int h = head;
    E element = (E) queue[h];
    queue[h] = null;
    head = (h + 1) & (queue.length - 1);
    return element;
  }

  @Override
  public E poll() {
    return pop();
  }

  @Override
  public boolean add(E newElement) {
    queue[tail] = newElement;
    if ((tail = (tail + 1) & (queue.length - 1)) == head) {
      doubleCapacity();
    }
    return true;
  }

  @Override
  public int size() {
    return (tail - head) & (queue.length - 1);
  }

  private void doubleCapacity() {
    int p = head;
    int n = queue.length;
    int r = n - p; // number of elements to the right of p
    int newCapacity = n << 1;

    Object[] newqueue = new Object[newCapacity];
    copyArray(queue, p, newqueue, 0, r);
    copyArray(queue, 0, newqueue, r, p);

    queue = newqueue;
    head = 0;
    tail = n;
  }

  private void copyArray(Object[] oldArray, int oldStart, Object[] newArray, int newStart, int lenght) {
    for (int i = oldStart; i < oldStart + lenght; i++) {
      newArray[newStart++] = oldArray[i];
    }
  }

  @Override
  public boolean addAll(Collection<? extends E> arg0) {
    return false;
  }

  @Override
  public void addFirst(E e) {
  }

  @Override
  public void clear() {
  }

  @Override
  public boolean containsAll(Collection<?> arg0) {
    return false;
  }

  @Override
  public boolean removeAll(Collection<?> arg0) {
    return false;
  }

  @Override
  public boolean retainAll(Collection<?> arg0) {
    return false;
  }

  @Override
  public Object[] toArray() {
    return null;
  }

  @Override
  public <T> T[] toArray(T[] arg0) {
    return null;
  }

  @Override
  public void addLast(E arg0) {

  }

  @Override
  public boolean contains(Object arg0) {
    return false;
  }

  @Override
  public Iterator<E> descendingIterator() {
    return null;
  }

  @Override
  public E element() {
    return null;
  }

  @Override
  public E getFirst() {
    return null;
  }

  @Override
  public E getLast() {
    return null;
  }

  @Override
  public Iterator<E> iterator() {
    return null;
  }

  @Override
  public boolean offer(E arg0) {
    return false;
  }

  @Override
  public boolean offerFirst(E arg0) {
    return false;
  }

  @Override
  public boolean offerLast(E arg0) {
    return false;
  }

  @Override
  public E peekFirst() {
    return null;
  }

  @Override
  public E peekLast() {
    return null;
  }

  @Override
  public E pollFirst() {
    return null;
  }

  @Override
  public E pollLast() {
    return null;
  }

  @Override
  public E remove() {
    return null;
  }

  @Override
  public E removeFirst() {
    return null;
  }

  @Override
  public boolean remove(Object arg0) {
    return false;
  }

  @Override
  public boolean removeFirstOccurrence(Object arg0) {
    return false;
  }

  @Override
  public E removeLast() {
    return null;
  }

  @Override
  public boolean removeLastOccurrence(Object arg0) {
    return false;
  }

  @Override
  public E peek() {
    return null;
  }

}