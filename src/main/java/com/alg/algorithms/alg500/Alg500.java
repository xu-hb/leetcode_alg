package com.alg.algorithms.alg500;

import com.alg.common.Pair;

import java.util.Arrays;

public class Alg500 {
    /**
     * 493.翻转对
     * 暴力求解，时间复杂度：O(N^2)
     * @param nums
     * @return
     */
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

    /**
     * 493.翻转对 2.0
     * @param nums
     * @return
     */
    public int reversePairs_2(int[] nums) {
        count = new int[nums.length];
        temps = new Pair[nums.length];

        Pair[] arr = new Pair[nums.length];
        for (int i=0;i< nums.length;i++){
            temps[i]=new Pair(nums[i],i);
        }
        sort(arr , 0 , nums.length-1);
        return Arrays.stream(count).sum();
    }

    int[] count =null;
    Pair[] temps = null;

    private void sort(Pair[] arr, int start, int end) {
        if (start==end)
            return;
        int middle = (end-start)/2 + start;
        sort(arr,start,middle);
        sort(arr,middle+1,end);
        merge(arr,start,middle,end);
    }
    private void merge(Pair[] arr, int start, int middle, int end){

    }
}
