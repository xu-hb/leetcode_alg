package com.alg.algorithms.leetcode.alg2000;

import java.util.Arrays;

public class Alg1990 {
    /**
     * 1984.学生分数的最小差值
     * 滑动窗口
     * 时间复杂度:O(NlogN)
     * 空间复杂度:O(logN)
     * @param nums
     * @param k
     * @return
     */
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int l=0,r=k-1;
        int min = Integer.MAX_VALUE;
        while (r<nums.length){
            min = Math.min(min,nums[r++]-nums[l++]);
        }
        return min;
    }
}
