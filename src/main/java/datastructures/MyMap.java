
package datastructures;

import java.util.*;

public class MyMap<K, V> implements Map {

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    transient int size;
    int threshold;
    final float loadFactor;
    transient Entry<K, V>[] entries;

    public MyMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
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
        throw new UnsupportedOperationException("Not supported yet.");
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

        //check first node (necessary..?)
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
        Entry<K, V> p;
        int n = table.length;
        int i;

        return null;
    }

    final Entry<K, V>[] resize() {
        Entry<K, V>[] oldTable = entries;

        return null;
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
    public Set keySet() {
        throw new UnsupportedOperationException("Not supported yet.");
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
}
