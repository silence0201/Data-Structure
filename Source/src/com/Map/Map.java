package com.Map;

/**
 * Project Name:Data-Structure
 * Package Name:com.Map
 * File Name: Map.java
 * Date:2019/11/10 下午1:14
 * Copyright © 2019 silence. All Rights Reserved.
 */

public interface Map<K, V> {
    int size();
    boolean isEmpty();
    void clear();
    V put(K key, V value);
    V get(K key);
    V remove(K key);
    boolean containsKey(K key);
    boolean containsValue(V value);
    void traversal(Visitor<K, V> visitor);

    public static abstract class Visitor<K, V> {
        boolean stop;
        public abstract boolean visit(K key, V value);
    }
}
