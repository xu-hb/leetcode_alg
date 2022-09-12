package com.alg.algorithms.leetcode.alg1700;

public class Alg1610 {
    /**
     * 1608.特殊数组的特征值
     * @param nums
     * @return
     */
    public int specialArray(int[] nums) {
        int[] cnts = new int[1010];
        for (int x : nums) cnts[x]++;
        for (int i = 1009, tot = 0; i >= 0; i--) {
            tot += cnts[i];
            if (i == tot) return i;
        }
        return -1;
    }
}
