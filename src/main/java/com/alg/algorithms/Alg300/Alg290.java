package com.alg.algorithms.Alg300;

import static com.alg.common.Util.swap;

public class Alg290 {
    /**
     * 283.移动零
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (null == nums || nums.length==0){
            return;
        }
        //交换
        int slow=0,fast=0;
        while (fast<nums.length){
            if (nums[fast]!=0){
                swap(nums , slow , fast);
                slow++;
            }
            fast++;
        }
        //零替代
        while (slow<nums.length){
            nums[slow]=0;
            slow++;
        }
    }
}
