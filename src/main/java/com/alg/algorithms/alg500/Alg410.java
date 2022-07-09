package com.alg.algorithms.alg500;

import java.util.Arrays;

public class Alg410 {

    /**
     * 410.分割数组的最大值
     * @param nums
     * @param m
     * @return
     */
    public int splitArray(int[] nums, int m) {
        //子数组和最小值
        int low = Arrays.stream(nums).max().getAsInt();
        //子数组和最大值
        int high = Arrays.stream(nums).sum();

        while (low<=high){
            int middle = low+(high-low)/2;
            //子数组和
            int sum = 0;
            //子数组数量
            int count = 1;

            for (int n : nums){
                if (sum+n>middle){
                    count++;
                    sum=0;
                }
                sum+=n;
            }
            if (count>m){
                low=middle+1;
            }else if (count<m){
                high=middle-1;
            }else {
                high=middle-1;
            }
        }
        return low;
    }
}
