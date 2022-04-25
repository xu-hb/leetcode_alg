package com.alg.algorithms.alg1000;

import java.util.Arrays;

public class Alg1000 {
    /**
     * 1005.k次取反后最大化的数组和
     * @param nums
     * @param k
     * @return
     */
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int absMin = Math.abs(nums[0]);
        int minCursor = 0;
        for (int i=0; i<nums.length; i++){
            if (absMin>Math.abs(nums[i])){
                minCursor=i;
                absMin=Math.abs(nums[i]);
            }
            //贪心：排序后的有序数组，局部值最大(负值取反)，则整体和最大
            if (nums[i]<0 && k>0){
                nums[i]=-nums[i];
                k--;
            }
        }
        if (k%2==1) nums[minCursor]=-nums[minCursor];
        return Arrays.stream(nums).sum();
    }
}
