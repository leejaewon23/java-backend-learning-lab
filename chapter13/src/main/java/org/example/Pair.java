package org.example;

public class Pair<K, V> {
    private K Key;
    private V Value;

    public Pair(K key, V value) {
        this.Key = key;
        this.Value = value;
    }

    public K getKey() { return Key; }
    public V getValue() { return Value; }
}
