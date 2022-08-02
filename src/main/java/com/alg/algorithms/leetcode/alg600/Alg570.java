package com.alg.algorithms.leetcode.alg600;

public class Alg570 {
    /**
     * 567.字符串的排列
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1>len2){
            return false;
        }

        int[] pCnt = new int[26];
        int[] window = new int[26];
        for (char c : s1.toCharArray()){
            pCnt[c-'a']++;
        }

        int left=0,right=0;
        while (right<len2){
            int curRight = s2.charAt(right)-'a';
            window[curRight]++;
            while (window[curRight]>pCnt[curRight]){
                int curLeft = s2.charAt(left)-'a';
                window[curLeft]--;
                left++;
            }
            if (right-left+1 == len1){
                return true;
            }
            right++;
        }
        return false;
    }
}
