package myjava.util;

import java.util.*;

public final class HashMapWithoutNullKey<K, V> implements MapWithoutNullKey<K, V> {
    private final HashMap<K, V> hashMap;

    public HashMapWithoutNullKey(HashMapType hashMapType) {
        Objects.requireNonNull(hashMapType);
        switch(hashMapType) {
            case HASH_MAP -> this.hashMap = new HashMap<>();
            case LINKED_HASH_MAP -> this.hashMap = new LinkedHashMap<>();
            default -> throw new IllegalArgumentException("hashMapType value invalid: " + hashMapType);
        }
    }

    @Override
    public int size() {
        return hashMap.size();
    }

    @Override
    public boolean isEmpty() {
        return hashMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        if(key == null) {
            return false;
        }
        return hashMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return hashMap.containsValue(value);
    }

    @Override
    public V get(Object key) {
        if(key == null) {
            return null;
        }
        return hashMap.get(key);
    }

    @Override
    public V put(K key, V value) {
        Objects.requireNonNull(key);
        return hashMap.put(key, value);
    }

    @Override
    public V remove(Object key) {
        if(key == null) {
            return null;
        }
        return hashMap.remove(key);
    }

    @Override
    public void clear() {
        hashMap.clear();
    }

    @Override
    public Set<K> keySet() {
        return hashMap.keySet();
    }

    @Override
    public Collection<V> values() {
        return hashMap.values();
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return hashMap.entrySet();
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        if(key == null) {
            return defaultValue;
        }
        return hashMap.getOrDefault(key, defaultValue);
    }

    @Override
    public V putIfAbsent(K key, V value) {
        Objects.requireNonNull(key);
        return hashMap.putIfAbsent(key, value);
    }

    @Override
    public boolean remove(Object key, Object value) {
        if(key == null) {
            return false;
        }
        return hashMap.remove(key, value);
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        if(key == null) {
            return false;
        }
        return hashMap.replace(key, oldValue, newValue);
    }

    @Override
    public V replace(K key, V value) {
        if(key == null) {
            return null;
        }
        return hashMap.replace(key, value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hashMap);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (HashMapWithoutNullKey) obj;
        return Objects.equals(this.hashMap, that.hashMap);
    }

    @Override
    public String toString() {
        return "HashMapWithoutNullKey[" +
                "hashMap=" + hashMap + ']';
    }
}
