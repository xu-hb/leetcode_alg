package com.alg.design.tree;

/**
 * 前缀树
 */
public class Trie {
    private TrieNode<Character> node;

    public Trie() {
        //虚拟节点
        this.node = new TrieNode<>('/');
    }

    public void insert(String word) {
        if (null==word) return;
        TrieNode cur = node;
        for (char c : word.toCharArray()){
            int index = c-'a';
            TrieNode<Character> next = cur.next[index];
            if (next ==null){
                next = new TrieNode<>(c);
                cur.next[index]=next;
            }
            cur = cur.next[index];
        }
        cur.isEnd=true;
    }

    public boolean search(String word) {
        TrieNode prefixNode = getPrefix(word);
        return prefixNode==null ? false : prefixNode.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode prefixNode = getPrefix(prefix);
        return prefixNode !=null;
    }

    /**
     * word在字典中的最短头匹配值
     * @param word
     * @return
     */
    public String minStartString(String word){
        StringBuilder sb = new StringBuilder();
        TrieNode<Character> cur = node;
        for (char c : word.toCharArray()){
            int index = c - 'a';
            TrieNode<Character> next = cur.next[index];
            if (next==null)
                return null;

            sb.append(next.val);
            if (next.isEnd){
                //最小匹配
                return sb.toString();
            }
            cur = cur.next[index];
        }
        return null;
    }

    protected TrieNode<Character> getNode(){
        return node;
    }

    protected TrieNode<Character> getPrefix(String prefix){
        if (null==prefix)
            return null;
        TrieNode<Character> cur = node;
        for (char c : prefix.toCharArray()){
            int index = c - 'a';
            TrieNode<Character> next = cur.next[index];
            if (next==null)
                return null;
            cur = cur.next[index];
        }
        return cur;
    }

}
