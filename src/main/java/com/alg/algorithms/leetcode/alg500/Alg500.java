package com.alg.algorithms.leetcode.alg500;

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
     * 归并排序
     * @param nums
     * @return
     */
    public int reversePairs_2(int[] nums) {
        temps = new int[nums.length];
        sort(nums , 0 , nums.length-1);
        return count;
    }

    int count=0;
    int[] temps = null;

    private void sort(int[] arr, int start, int end) {
        if (start==end)
            return;
        int middle = (end-start)/2 + start;
        sort(arr,start,middle);
        sort(arr,middle+1,end);
        merge(arr,start,middle,end);
    }
    private void merge(int[] arr, int start, int middle, int end){
        for (int i=start;i<=end;i++){
            temps[i]=arr[i];
        }

        //计算
        int lastCur=middle+1;
        for (int i=start;i<=middle;i++){
            while (lastCur<=end && (long)arr[i] > (long)arr[lastCur] * 2){
                lastCur++;
            }
            count +=lastCur-(middle+1);
        }

        int i=start,j=middle+1;
        for (int p=start;p<=end;p++){
            if (i==middle+1){
                arr[p]=temps[j++];
            }else if (j==end+1){
                arr[p]=temps[i++];
            }else if (temps[i]>temps[j]){
                arr[p]=temps[j++];
            }else {
                arr[p]=temps[i++];
            }
        }
    }
}
