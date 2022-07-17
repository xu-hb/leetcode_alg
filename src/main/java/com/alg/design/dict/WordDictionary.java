package com.alg.design.dict;

import com.alg.design.tree.Trie;
import com.alg.design.tree.TrieNode;

public class WordDictionary extends Trie{
    public WordDictionary() {
        super();
    }

    public void addWord(String word) {
        super.insert(word);
    }

    public boolean search(String word) {
        return dfs(word,0,super.getNode());
    }

    protected boolean dfs(String prefix , int index, TrieNode<Character> root){
        if (index==prefix.length()){
            return root.isEnd;
        }
        char c = prefix.charAt(index);
        if (c=='.'){
            for (int i=0;i<26;i++){
                TrieNode<Character> next = root.next[i];
                //需递归完，直到有一个符合条件的值返回
                if (next !=null && dfs(prefix , index+1 , next)){
                    return true;
                }
            }
        }else {
            int nextIndex = c-'a';
            TrieNode<Character> next = root.next[nextIndex];
            if (next !=null && dfs(prefix , index +1,next)){
                return true;
            }
        }
        return false;
    }
}
