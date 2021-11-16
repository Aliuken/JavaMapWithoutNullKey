package myjava.util;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public final class MapWithoutNullKey<K, V> implements Map<K, V> {
    private final Map<K, V> map;

    public MapWithoutNullKey(MapType mapType) {
        Objects.requireNonNull(mapType);
        switch(mapType) {
            case HASH_MAP -> this.map = new HashMap<>();
            case LINKED_HASH_MAP -> this.map = new LinkedHashMap<>();
            case TREE_MAP -> this.map = new TreeMap<>();
            default -> throw new IllegalArgumentException("invalid mapType: " + mapType);
        }
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
        if(key == null) {
            return false;
        }
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public V get(Object key) {
        if(key == null) {
            return null;
        }
        return map.get(key);
    }

    @Override
    public V put(K key, V value) {
        Objects.requireNonNull(key);
        return map.put(key, value);
    }

    @Override
    public V remove(Object key) {
        if(key == null) {
            return null;
        }
        return map.remove(key);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        if(m.containsKey(null)) {
            throw new NullPointerException();
        }
        map.putAll(m);
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
        if(key == null) {
            return defaultValue;
        }
        return map.getOrDefault(key, defaultValue);
    }

    @Override
    public void forEach(BiConsumer<? super K, ? super V> action) {
        map.forEach(action);
    }

    @Override
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        map.replaceAll(function);
    }

    @Override
    public V putIfAbsent(K key, V value) {
        Objects.requireNonNull(key);
        return map.putIfAbsent(key, value);
    }

    @Override
    public boolean remove(Object key, Object value) {
        if(key == null) {
            return false;
        }
        return map.remove(key, value);
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        if(key == null) {
            return false;
        }
        return map.replace(key, oldValue, newValue);
    }

    @Override
    public V replace(K key, V value) {
        if(key == null) {
            return null;
        }
        return map.replace(key, value);
    }

    @Override
    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        Objects.requireNonNull(key);
        return map.computeIfAbsent(key, mappingFunction);
    }

    @Override
    public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(key);
        return map.computeIfPresent(key, remappingFunction);
    }

    @Override
    public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(key);
        return map.compute(key, remappingFunction);
    }

    @Override
    public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(key);
        return map.merge(key, value, remappingFunction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(map);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (MapWithoutNullKey) obj;
        return Objects.equals(this.map, that.map);
    }

    @Override
    public String toString() {
        return "MapWithoutNullKey[" +
                "map=" + map + ']';
    }
}
