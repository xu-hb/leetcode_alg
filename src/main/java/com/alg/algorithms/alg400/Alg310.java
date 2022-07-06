package com.alg.algorithms.alg400;

public class Alg310 {

    int[] nums =null;

    public Alg310(int[] nums) {
        this.nums = nums;
    }
    /**
     * 303.区域和检索-数组不可变
     * 时间复杂度：O(N)
     * @param left
     * @param right
     * @return
     */
    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i=left;i<=right;i++){
            sum+=nums[i];
        }
        return sum;
    }
}
