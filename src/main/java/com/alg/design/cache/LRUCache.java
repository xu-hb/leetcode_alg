package com.alg.design.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU
 */
public class LRUCache {
    //哈希索引（应题目要求，设置为Integer类型）
    private Map<Integer , Node<Integer , Integer>> map;
    //双向链表
    private DoubleList<Integer , Integer> doubleList;
    //容量
    int cap;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        doubleList = new DoubleList<>();
        cap = capacity;
    }

    /**
     * 获取元素
     * 时间复杂度：O(1)
     * @param key
     * @return
     */
    public int get(int key) {
        if (! map.containsKey(key))
            return -1;
        makeRecent(key);
        return map.get(key).val;
    }

    /**
     * 新增元素
     * 时间复杂度：O(1)
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        putRecent(key, value);
    }

    /**
     * put
     * @param key
     * @param value
     */
    private void putRecent(int key , int value){
        if (map.containsKey(key)){
            //已存在，则更新值
            Node<Integer, Integer> node = map.get(key);
            doubleList.remove(node);
            //同时置为最近使用
            doubleList.addFirst(node);
            node.val = value;
        }else {
            //不存在则新增
            addRecent(key, value);
        }
    }

    /**
     * 添加最近使用
     * @param key
     * @param value
     */
    private void addRecent(int key , int value){
        //不存在则新增
        Node<Integer, Integer> node = new Node<>(key , value);
        doubleList.addFirst(node);
        //map也需存储索引
        map.put(key , node);
        if (doubleList.getSize()>cap){
            //超过容量，删除最久未使用的元素
            removeLastRecent();
        }
    }

    /**
     * 将元素置为最近使用
     * @param key
     */
    private void makeRecent(int key){
        if (! map.containsKey(key))
            return;
        Node<Integer, Integer> node = map.get(key);
        //LRU:最近访问的元素要至于链表头
        doubleList.remove(node);
        doubleList.addFirst(node);
    }

    /**
     * 删除
     * @param key
     */
    private void deleteKey(int key){
        doubleList.remove(map.get(key));
        map.remove(key);
    }

    /**
     * 移除最近未使用的元素
     */
    private void removeLastRecent(){
        Node<Integer, Integer> last = doubleList.removeLast();
        map.remove(last.key);
    }

}
