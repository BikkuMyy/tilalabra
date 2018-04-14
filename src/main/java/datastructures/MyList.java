package datastructures;

import java.util.*;

/**
 * Luokka korvaa valmiin ArrayList-tietorakenteen.
 *
 * @author mari
 * @param <E>
 */
public class MyList<E> implements List {

    private int size;
    private Object[] elements;
    private final int DEFAULT_CAPACITY = 10;

    public MyList() {
        this.size = 0;
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public boolean add(Object o) {
        if (size + 1 >= elements.length) {
            this.elements = Arrays.copyOf(elements, size * 2);
        }
        elements[size++] = o;
        return true;
    }

    @Override
    public Object get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " >= " + this.size);
        }
        return elements[index];
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    @Override
    public Iterator iterator() {
        return new MyIterator();
    }
    
    private class MyIterator implements Iterator {
        int currentIndex;
        int lastReturned = -1;

        @Override
        public boolean hasNext() {
            return currentIndex != size;
        }

        @Override
        public Object next() {
            int i = currentIndex;
            currentIndex++;
            Object[] elements = MyList.this.elements;
            return (E) elements[lastReturned = i];
        }

    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ListIterator listIterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ListIterator listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object set(int index, Object element) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(int index, Object element) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object remove(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean containsAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean addAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray(Object[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}