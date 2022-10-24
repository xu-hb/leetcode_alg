package com.alg.algorithms.leetcode.alg1800;

import java.util.Arrays;

public class Alg1770 {
    /**
     * 1768.交替合并字符串
     * 时间复杂度：O(N+M)
     * 空间复杂度：O(N+M)
     * @param word1
     * @param word2
     * @return
     */
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        char[] letter = new char[n+m];
        int cur1=0,cur2=0,cur=0;
        while (cur<n+m){
            if (cur1<n) letter[cur++]=word1.charAt(cur1++);
            if (cur2<m) letter[cur++]=word2.charAt(cur2++);
        }
        return String.valueOf(letter);
    }
}
