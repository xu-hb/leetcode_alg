package com.alg.algorithms.leetcode.alg1500;

public class Alg1420 {
    /**
     * 1413.逐步求和得到正数的最小值
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int minStartValue(int[] nums) {
        int min = nums[0];
        for (int i=1;i<nums.length;i++){
            //累计和
            nums[i] += nums[i-1];
            min = Math.min(min , nums[i]);
        }
        return 1-min>0 ? 1-min : 1;
    }
}
