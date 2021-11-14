package myjava.util;

import java.util.*;

public final class HashMapWithoutNullKey<K, V> implements MapWithoutNullKey<K, V> {
    private final HashMap<K, V> map;

    public HashMapWithoutNullKey() {
        this.map = new HashMap<>();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        Objects.requireNonNull(key);
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public V get(Object key) {
        Objects.requireNonNull(key);
        return map.get(key);
    }

    @Override
    public V put(K key, V value) {
        Objects.requireNonNull(key);
        return map.put(key, value);
    }

    @Override
    public V remove(Object key) {
        Objects.requireNonNull(key);
        return map.remove(key);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        return map.values();
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return map.entrySet();
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        Objects.requireNonNull(key);
        return map.getOrDefault(key, defaultValue);
    }

    @Override
    public V putIfAbsent(K key, V value) {
        Objects.requireNonNull(key);
        return map.putIfAbsent(key, value);
    }

    @Override
    public boolean remove(Object key, Object value) {
        Objects.requireNonNull(key);
        return map.remove(key, value);
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        Objects.requireNonNull(key);
        return map.replace(key, oldValue, newValue);
    }

    @Override
    public V replace(K key, V value) {
        Objects.requireNonNull(key);
        return map.replace(key, value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(map);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (HashMapWithoutNullKey) obj;
        return Objects.equals(this.map, that.map);
    }

    @Override
    public String toString() {
        return "HashMapWithoutNullKey[" +
                "map=" + map + ']';
    }
}
