
package datastructures;

import java.util.*;


public class MyMap<K, V> implements Map {

    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; //16
    static final int MAXIMUM_CAPACITY = 1 << 30;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    //The next size value at which to resize (capacity * load factor).
    int threshold;
    final float loadFactor;
    transient Entry<K, V>[] entries;
    transient int size;

    public MyMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        threshold = (int)(DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
        entries = new Entry[DEFAULT_INITIAL_CAPACITY];
    }

    /**
     * Hash implementation from Java 8
     * @param   key
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
    public Object get(Object key) {
        Entry<K, V> e = getEntry(hash(key), key);
        return e == null ? null : e.value;
    }

    final Entry<K, V> getEntry(int hash, Object key) {
        Entry<K, V>[] table = entries;
        int n = table.length;
        Entry<K, V> first = table[(n - 1) & hash];
        Entry e;
        K k = first.key;

        //check first node
        if (table != null && n > 0 && first != null) {
            if (first.hash == hash && (k == key || key != null && key.equals(k))) {
                return first;
            }
        }
        if ((e = first.next) != null) {
            do {
                if (e.hash == hash && ((k = (K) e.key) == key || (key != null && key.equals(k)))) {
                    return e;
                }
            } while ((e = e.next) != null);
        }

        return null;
    }

    @Override
    public V put(Object key, Object value) {
        return putValue(hash(key), (K) key, (V) value);
    }

    final V putValue(int hash, K key, V value) {
        Entry<K, V>[] table = entries;
        Entry<K, V> toPut;
        int n = table.length;
        int i;

        if ((toPut = table[i = (n - 1) & hash]) == null)
            table[i] = new Entry(key, value, null, hash);
        else {
            Entry<K, V> e;
            K k;

            if (toPut.hash == hash && ((k = toPut.key) == key || (key != null && key.equals(k))))
                e = toPut;
            else {
                for (int binCount = 0;; ++binCount) {
                    if ((e = toPut.next) == null) {
                        toPut.next = new Entry(key, value, null, hash);
                        break;
                    }
                    if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    toPut = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                return oldValue;
            }
        }

        if (++size > threshold) {
            resize();
        }

        return null;
    }

    final Entry<K, V>[] resize() {
        Entry<K, V>[] oldTable = entries;
        int oldCapacity = oldTable.length;
        int oldThr = threshold;
        int newCapacity = oldCapacity << 1;
        int newThr;

        if (oldCapacity >= MAXIMUM_CAPACITY) {
            threshold = Integer.MAX_VALUE;
            return oldTable;
        }

        Entry<K, V>[] newTable = new Entry[newCapacity];
        transfer(newTable);
        entries = newTable;
        threshold = (int) (newCapacity * loadFactor);

        return null;
    }

    void transfer(Entry[] newTable) {
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
    public Object remove(Object key) {
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

    @Override
    public Set<K> keySet() {
        return new MyKeySet();
    }

    @Override
    public Collection values() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set entrySet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    static class Entry<K, V> implements Map.Entry {
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
        public Object setValue(Object value) {
            V oldValue = this.value;
            this.value = (V) value;
            return oldValue;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Entry<?, ?> other = (Entry<?, ?>) obj;
            if (!Objects.equals(this.key, other.key)) {
                return false;
            }
            if (!Objects.equals(this.value, other.value)) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }
    }

    private final class MyKeySet extends AbstractSet<K> {

        @Override
        public Iterator<K> iterator() {
            return new MyKeyIterator();
        }

        @Override
        public int size() {
            return size;
        }
    }

    final class MyValues extends AbstractCollection<V>{

		@Override
		public Iterator<V> iterator() {
			return new MyValueIterator();
		}

		@Override
		public int size() {
			return size;
		}

    }

    private final class MyKeyIterator implements Iterator<K> {
        Entry<K, V> next;
        int index;
        Entry<K, V> current;

        public final boolean hasNext() {
            return next != null;
        }

        public K next() {
            Entry<K, V> e = next;

            if ((next = e.next) == null) {
                Entry[] t = entries;
                while (index < t.length && (next = t[index++]) == null)
                    ;
            }
            current = e;
            return e.getKey();
        }
    }

    private final class MyValueIterator implements Iterator<V> {
        Entry<K, V> next;
        int index;
        Entry<K, V> current;

        public V next() {
            Entry<K, V> e = next;

            if ((next = e.next) == null) {
                Entry[] t = entries;
                while (index < t.length && (next = t[index++]) == null)
                    ;
            }
            current = e;
            return e.getValue();
        }

		@Override
		public boolean hasNext() {
			return next != null;
		}
    }
}
