package com.alg.algorithms.alg400;

public class Alg310 {

    int[] nums =null;

//    public Alg310(int[] nums) {
//        this.nums = nums;
//    }
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

    /**
     * 303.区域和检索-数组不可变 II
     * 前缀和，提前求和
     * 时间复杂度:O(1)
     * @param left
     * @param right
     * @return
     */
    public int sumRange_2(int left, int right){
        return nums[right+1] - nums[left];
    }

    public Alg310(int[] n) {
        //计算和
        this.nums = new int[n.length+1];
        for (int i=1;i<nums.length;i++){
            nums[i] = nums[i-1] + n[i-1];
        }
    }

}
