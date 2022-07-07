package com.alg.algorithms.alg500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Alg440 {
    /**
     * 438.找到字符串中所有字母异位词
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        List<Integer> res = new ArrayList<>();
        if(sLen < pLen) return res;

        int[] pCnt = new int[26];
        int[] window = new int[26];

        for(int i = 0; i < pLen; i++){
            pCnt[p.charAt(i) - 'a'] ++;
        }

        int left=0,right=0;
        while (right<sLen){
            int curRight = s.charAt(right) - 'a';
            window[curRight]++;
            while (window[curRight]>pCnt[curRight]){
                int curLeft = s.charAt(left) - 'a';
                window[curLeft]--;
                left++;
            }
            if(right - left + 1 == pLen){
                res.add(left);
            }
            right++;
        }
        return res;
    }
}
