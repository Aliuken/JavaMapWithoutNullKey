package myjava.util;

import java.util.*;

public sealed interface MapWithoutNullKey<K, V> permits HashMapWithoutNullKey {
    // Query Operations

    int size();
    boolean isEmpty();
    boolean containsKey(Object key);
    boolean containsValue(Object value);
    V get(Object key);

    // Modification Operations

    V put(K key, V value);
    V remove(Object key);


    // Bulk Operations

    void clear();

    // Views

    Set<K> keySet();
    Collection<V> values();
    Set<Map.Entry<K, V>> entrySet();

    // Comparison and hashing

    boolean equals(Object o);
    int hashCode();

    // Defaultable map methods

    V getOrDefault(Object key, V defaultValue);
    V putIfAbsent(K key, V value);
    boolean remove(Object key, Object value);
    boolean replace(K key, V oldValue, V newValue);
    V replace(K key, V value);
}
