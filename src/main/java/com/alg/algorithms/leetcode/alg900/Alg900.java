package com.alg.algorithms.leetcode.alg900;

import java.util.Arrays;

public class Alg900 {
    /**
     * 899.有序队列
     * @param s
     * @param k
     * @return
     */
    public String orderlyQueue(String s, int k) {
        if (k !=1){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return String.valueOf(arr);
        }
        //k==1，遍历一次
        String smallest = s;
        StringBuilder sb = new StringBuilder(s);
        int n = s.length();
        for (int i = 1; i < n; i++) {
            char c = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(c);
            if (sb.toString().compareTo(smallest) < 0) {
                smallest = sb.toString();
            }
        }
        return smallest;
    }
}
