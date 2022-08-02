package com.alg.algorithms.leetcode.alg1000;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Alg1000 {
    /**
     * 1005.k次取反后最大化的数组和
     * 贪心算法
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

    /**
     * 1005.k次取反后最大化的数组和 2
     * @param nums
     * @param k
     * @return
     */
    public int largestSumAfterKNegations2(int[] nums, int k) {
        //按绝对值最大到最小排序
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1,o2)->Math.abs(o2)-Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();

        for (int i=0; i<nums.length; i++){
            //贪心：排序后的有序数组，局部值最大(负值取反)，则整体和最大
            if (nums[i]<0 && k>0){
                nums[i]=-nums[i];
                k--;
            }
        }
        int len = nums.length;
        if (k%2==1) nums[len-1]=-nums[len-1];
        return Arrays.stream(nums).sum();
    }
}
