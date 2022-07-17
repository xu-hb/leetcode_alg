package com.alg.design.tree;

public class TrieNode<V> {
    public V val;
    public boolean isEnd;
    public TrieNode[] next;
    public TrieNode(V val){
        this.val = val;
        this.isEnd = false;
        this.next = new TrieNode[26];
    }
}
