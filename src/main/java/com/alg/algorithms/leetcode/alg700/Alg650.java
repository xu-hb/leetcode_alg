package com.alg.algorithms.leetcode.alg700;

import com.alg.design.tree.Trie;

import java.util.List;

public class Alg650 {
    /**
     * 648.单词替换
     * @param dictionary
     * @param sentence
     * @return
     */
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String dict : dictionary){
            trie.insert(dict);
        }
        String[] arr = sentence.split(" ");
        for (int i=0;i<arr.length;i++){
            String sen = arr[i];
            String matchPrefix = trie.minStartString(sen);
            if (matchPrefix !=null && !matchPrefix.equals("")){
                arr[i] = matchPrefix;
            }
        }
        return String.join(" ", arr);
    }
}
