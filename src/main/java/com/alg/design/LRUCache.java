package com.alg.design;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * LRU缓存
 */
public class LRUCache extends LinkedHashMap<Integer , Integer> {
    //缓存容量
    private int cacheSize;

    public LRUCache(int capacity) {
        super(capacity , 1, true);
        this.cacheSize = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key , -1);
    }

    public void put(int key, int value) {
        super.put(key , value);
    }

    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
        return size()>cacheSize;
    }
}
