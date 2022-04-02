package com.alg.common;

public class Util {
    public static void swap(int[]nums , int i , int k){
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }
}
