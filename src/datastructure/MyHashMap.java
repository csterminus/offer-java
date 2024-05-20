package datastructure;

import java.util.Objects;

/**
 * @author chengshi
 * @date 2024/5/16 17:35
 */
public class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private Entry<K, V>[] buckets;
    private int size;

    public MyHashMap() {
        buckets = new Entry[DEFAULT_CAPACITY];
    }

    public MyHashMap(int capacity) {
        buckets = new Entry[capacity];
        size = 0;
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("cherry", 3);

        System.out.println("Value for key 'apple': " + map.get("apple")); // Output: 1
        System.out.println("Value for key 'banana': " + map.get("banana")); // Output: 2
        System.out.println("Value for key 'cherry': " + map.get("cherry")); // Output: 3

        map.remove("banana");
        System.out.println("Value for key 'banana' after removal: " + map.get("banana")); // Output: null
    }

    private int hash(K key) {
        return Objects.hashCode(key) % buckets.length;
    }

    public void put(K key, V value) {
        if (key == null) {
            putForNullKey(value);
            return;
        }
        int hash = hash(key);
        Entry<K, V> entry = new Entry<>(key, value);
        if (buckets[hash] == null) {
            buckets[hash] = entry;
            size++;
        } else {
            Entry<K, V> existing = buckets[hash];
            while (existing.next != null) {
                if (existing.key.equals(key)) {
                    existing.value = value;
                    return;
                }
                existing = existing.next;
            }
            if (existing.key.equals(key)) {
                existing.value = value;
            } else {
                existing.next = entry;
                size++;
            }
        }
        if ((double) size / buckets.length >= LOAD_FACTOR) {
            resize();
        }
    }

    private void putForNullKey(V value) {
        Entry<K, V> entry = new Entry<>(null, value);
        if (buckets[0] == null) {
            buckets[0] = entry;
            size++;
        } else {
            Entry<K, V> existing = buckets[0];
            while (existing.next != null) {
                if (existing.key == null) {
                    existing.value = value;
                    return;
                }
                existing = existing.next;
            }
            if (existing.key == null) {
                existing.value = value;
            } else {
                existing.next = entry;
                size++;
            }
        }
        if ((double) size / buckets.length >= LOAD_FACTOR) {

        }
    }

    public V get(K key) {
        if (key == null) {
            return getForNullKey();
        }
        int hash = hash(key);
        Entry<K, V> entry = buckets[hash];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    private V getForNullKey() {
        Entry<K, V> entry = buckets[0];
        while (entry != null) {
            if (entry.key == null) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public int size() {
        return size;
    }

    private void resize() {
        int newCapacity = buckets.length * 2;
        Entry<K, V>[] newBuckets = new Entry[newCapacity];
        for (Entry<K, V> entry : buckets) {
            while (entry != null) {
                int hash = entry.key == null ? 0 : hash(entry.key);
                Entry<K, V> next = entry.next;
                entry.next = newBuckets[hash];
                newBuckets[hash] = entry;
                entry = next;
            }
        }
        buckets = newBuckets;
    }

    public void remove(K key) {
        if (key == null) {
            removeForNullKey();
            return;
        }
        int hash = hash(key);
        Entry<K, V> entry = buckets[hash];
        if (entry == null) {
            return;
        }
        if (entry.key.equals(key)) {
            buckets[hash] = entry.next;
            size--;
            return;
        }
        Entry<K, V> prev = entry;
        entry = entry.next;
        while (entry != null) {
            if (entry.key.equals(key)) {
                prev.next = entry.next;
                size--;
                return;
            }
            prev = entry;
            entry = entry.next;
        }
    }

    private void removeForNullKey() {
        Entry<K, V> entry = buckets[0];
        if (entry == null) {
            return;
        }
        if (entry.key == null) {
            buckets[0] = entry.next;
            size--;
            return;
        }
        Entry<K, V> prev = entry;
        entry = entry.next;
        while (entry != null) {
            if (entry.key == null) {
                prev.next = entry.next;
                size--;
                return;
            }
            prev = entry;
            entry = entry.next;
        }
    }

    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
