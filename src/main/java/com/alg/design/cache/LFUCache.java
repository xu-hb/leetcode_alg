package com.alg.design.cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * LFU:最不经常使用
 */
public class LFUCache {
    //KV map
    private Map<Integer,Node<Integer , Integer>> cache;
    //出现次数-key
    private Map<Integer , LinkedHashSet<Node<Integer , Integer>>> freqKeyMap;
    //容量
    int cap;
    //频次最小值
    int min;
    int size;

    public LFUCache(int capacity) {
        cap = capacity;
        cache = new HashMap<>(capacity);
        freqKeyMap = new HashMap<>();
        size=0;
    }

    public int get(int key) {
        if (cap==0) return -1;
        if (! cache.containsKey(key)) return -1;
        Node<Integer, Integer> node = cache.get(key);
        incrFreq(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (cap==0) return;
        if (cache.containsKey(key)){
            Node<Integer, Integer> node = cache.get(key);
            node.val = value;
            incrFreq(node);
        }else {
            //新增
            if (size==cap){
                Node<Integer, Integer> delNode = removeLastNode();
                cache.remove(delNode.key);
                size--;
            }
            Node<Integer, Integer> node = new Node(key ,value);
            cache.put(key , node);
            addNode(node);
            size++;
        }
    }

    private void addNode(Node<Integer, Integer> node) {
        LinkedHashSet<Node<Integer,Integer>> set = freqKeyMap.get(node.freq);
        if (set==null){
            set = new LinkedHashSet<>();
            freqKeyMap.put(1, set);
        }
        set.add(node);
        min = 1;
    }

    private Node<Integer, Integer> removeLastNode() {
        LinkedHashSet<Node<Integer,Integer>> set = freqKeyMap.get(min);
        Node<Integer,Integer> delNode = set.iterator().next();
        set.remove(delNode);
        return delNode;
    }

    /**
     * 增加频次
     * @param node
     */
    private void incrFreq(Node<Integer, Integer> node){
        int freq = node.freq;
        LinkedHashSet<Node<Integer,Integer>> set = freqKeyMap.get(freq);
        set.remove(node);
        if (freq==min && set.size() ==0){
            min = freq+1;
        }
        node.freq++;
        LinkedHashSet<Node<Integer,Integer>> newSet = freqKeyMap.get(node.freq);
        if (null==newSet){
            newSet = new LinkedHashSet<>();
            freqKeyMap.put(node.freq,newSet);
        }
        newSet.add(node);
    }
}
