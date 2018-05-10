
package datastructures;

import java.util.*;

public class MyMap<K, V> extends AbstractMap<K, V> implements Map<K, V> {

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final int MAXIMUM_CAPACITY = 1 << 30;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    // Threshold = next size value at which to resize (capacity * load factor).
    int threshold;
    final float loadFactor;
    transient Entry<K, V>[] entries;
    transient int size;
    transient Set<K> keySet;
    transient Collection<V> values;

    public MyMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
        entries = new Entry[DEFAULT_INITIAL_CAPACITY];
        keySet = null;
        values = null;
    }

    /**
     * Hash implementation from Java 8
     * 
     * @param key
     */
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
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
    public boolean containsKey(Object key) {
        int hash = hash(key.hashCode());
        for (Entry<K, V> e = entries[indexFor(hash, entries.length)]; e != null; e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k))))
                return true;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public V get(Object key) {
        Entry<K, V> e = getEntry(hash(key), key);
        return e == null ? null : e.value;
    }

    final Entry<K, V> getEntry(int hash, Object key) {
        Entry<K, V>[] table;
        int n;
        Entry<K, V> first;
        Entry e;
        K k;

        // check first node
        if ((table = entries) != null && (n = table.length) > 0 && (first = table[(n - 1) & hash]) != null) {

            if (first.hash == hash && ((k = first.key) == key || (key != null && key.equals(k)))) {
                return first;
            }

            if ((e = first.next) != null) {
                do {
                    if (e.hash == hash && ((k = (K) e.key) == key || (key != null && key.equals(k)))) {
                        return e;
                    }
                } while ((e = e.next) != null);
            }
        }
        return null;
    }

    @Override
    public V put(Object key, Object value) {
        int hash = hash(key);
        int i = indexFor(hash, entries.length);
        for (Entry<K, V> e = entries[i]; e != null; e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                V oldValue = e.value;
                e.value = (V) value;

                return oldValue;
            }
        }

        Entry<K, V> e = entries[i];
        entries[i] = new Entry<>((K) key, (V) value, e, hash);
        if (++size > threshold) {
            resize();
        }

        return null;
    }

    private Entry<K, V>[] resize() {
        Entry<K, V>[] oldTable = entries;
        int oldCapacity = oldTable.length;
        int newCapacity = oldCapacity << 1;

        Entry<K, V>[] newTable = new Entry[newCapacity];
        transfer(newTable);
        entries = newTable;
        threshold = (int) (newCapacity * loadFactor);

        return null;
    }

    private void transfer(Entry[] newTable) {
        Entry[] src = entries;
        int newCapacity = newTable.length;
        for (int j = 0; j < src.length; j++) {
            Entry<K, V> e = src[j];
            if (e != null) {
                src[j] = null;
                do {
                    Entry<K, V> next = e.next;
                    int i = indexFor(e.hash, newCapacity);
                    e.next = newTable[i];
                    newTable[i] = e;
                    e = next;
                } while (e != null);
            }
        }
    }

    static int indexFor(int h, int length) {
        return h & (length - 1);
    }

    @Override
    public V remove(Object key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void putAll(Map m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Set entrySet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Set<K> keySet() {
        Set<K> ks = keySet;
        if (ks == null) {
            ks = new MyKeySet();
            keySet = ks;
        }
        return ks;
    }

    public Collection<V> values() {
        Collection<V> vs = values;
        if (vs == null) {
            vs = new MyValues();
            values = vs;
        }
        return vs;
    }

    final class MyKeySet<K> extends AbstractSet<K> {
        public final int size() {
            return size;
        }

        public final Iterator<K> iterator() {
            return new MyKeyIterator();
        }
    }

    final class MyValues extends AbstractCollection<V> {
        public final int size() {
            return size;
        }

        public final Iterator<V> iterator() {
            return new MyValueIterator();
        }
    }

    private final class MyKeyIterator<K> extends MyHashIterator implements Iterator<K> {
        public K next() {
            return (K) nextEntry().getKey();
        }
    }

    private final class MyValueIterator extends MyHashIterator implements Iterator<V> {
        public V next() {
            return nextEntry().getValue();
        }
    }

    abstract class MyHashIterator {
        Entry<K, V> next;
        int index;

        MyHashIterator() {
            Entry<K, V>[] table = entries;
            next = null;
            index = 0;
            if (table != null && size > 0) { // advance to first entry
                do {
                } while (index < table.length && (next = table[index++]) == null);
            }
        }

        public boolean hasNext() {
            return next != null;
        }

        final Entry<K, V> nextEntry() {
            Entry<K, V>[] table;
            Entry<K, V> e = next;

            if (e == null) {
                throw new NoSuchElementException();
            }

            if ((next = e.next) == null && (table = entries) != null) {
                do {
                } while (index < table.length && (next = table[index++]) == null);
            }

            return e;
        }
    }

    static class Entry<K, V> implements Map.Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;
        int hash;

        Entry(K key, V value, Entry<K, V> next, int hash) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.hash = hash;
        }

        @Override
        public final K getKey() {
            return this.key;
        }

        @Override
        public final V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V value) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public boolean equals(Object obj) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }
    }
}
