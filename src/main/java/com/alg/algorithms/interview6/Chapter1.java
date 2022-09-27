package com.alg.algorithms.interview6;

public class Chapter1 {
    /**
     * 01.02. 判定是否互为字符重排
     * 时间复杂度：O(N)
     * 空间复杂度：O(C)
     * @param s1
     * @param s2
     * @return
     */
    public boolean CheckPermutation(String s1, String s2) {
        int n = s1.length(), m = s2.length(), tot = 0;
        if (n != m) return false;
        int[] cnt = new int[256];
        for (int i = 0; i < n; i++) {
            if (++cnt[s1.charAt(i)] == 1) tot++;
            if (--cnt[s2.charAt(i)] == 0) tot--;
        }
        return tot == 0;
    }
}
