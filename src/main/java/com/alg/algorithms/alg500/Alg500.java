package com.alg.algorithms.alg500;

public class Alg500 {
    /**
     * 493.翻转对
     * 暴力求解，时间复杂度：O(N^2)
     * @param nums
     * @return
     */
    //给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
    public int reversePairs(int[] nums) {
        int result = 0;
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                //防止越界，向上取整
                if ((nums[i]+1)/2>nums[j])
                    result++;
            }
        }
        return result;
    }
}
