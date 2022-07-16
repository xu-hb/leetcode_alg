package com.alg.design.cache;

/**
 * 双向链表节点
 */
public class Node<K,V> {
    public K key;
    public V val;
    //前驱、后继指针
    public Node<K,V> prev,next;

    public Node(K key , V val){
        this.key = key;
        this.val = val;
    }
}
