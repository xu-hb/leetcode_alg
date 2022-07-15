package com.alg.algorithms.alg1000;

import java.util.Random;

public class Alg920 {
    /**
     * 912.排序数组
     * 归并排序
     * 时间复杂度：O(NlogN)
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        temps = new int[nums.length];
        mergeSort(nums,0 , nums.length-1);
        return nums;
    }
    int[] temps=null;

    /**
     * 归并排序
     * @param nums
     * @param low
     * @param high
     */
    private void mergeSort(int[] nums , int low , int high){
        if (low==high) return;
        int middle = low+(high-low)/2;
        mergeSort(nums,low,middle);
        mergeSort(nums,middle+1,high);
        //归并
        merge(nums,low,middle,high);
    }

    private void merge(int[] nums, int low, int middle, int high) {
        for (int i=low;i<=high;i++){
            //暂存
            temps[i]=nums[i];
        }
        int i=low,j=middle+1;
        for (int p=low;p<=high;p++){
            if (i==middle+1){
                nums[p]=temps[j++];
            }else if (j==high+1){
                nums[p] = temps[i++];
            }else if (temps[i]>temps[j]){
                nums[p] = temps[j++];
            }else {
                nums[p] = temps[i++];
            }
        }
    }

    /**
     * 912.排序数组 2.0
     * 快排
     * @param nums
     * @return
     */
    public int[] sortArray_2(int[] nums) {
        quickSort(nums , 0 , nums.length-1);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l<r){
            int p = partition(nums , l , r);
            quickSort(nums , l , p);
            quickSort(nums , p+1 , r);
        }
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        while (l<r){
            while (l<r && nums[r]>=pivot) r--;
            nums[l] = nums[r];
            while (l<r && nums[l]<=pivot) l++;
            nums[r]=nums[l];
        }
        nums[l]=pivot;
        return l;
    }
}
