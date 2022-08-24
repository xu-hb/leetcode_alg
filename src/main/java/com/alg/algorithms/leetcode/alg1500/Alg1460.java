package com.alg.algorithms.leetcode.alg1500;

public class Alg1460 {
    /**
     * 1460.翻转子数组使两个数组相等
     * @param target
     * @param arr
     * @return
     */
    public boolean canBeEqual(int[] target, int[] arr) {
        int n=arr.length;
        int l=0,r=0;
        while (r<n){
            if (target[l]==arr[r]){
                if (l==r){
                    l++;
                    r++;
                }else {
                    swap(arr,l,r);
                    l++;
                    r=l;
                }
            }else {
                r++;
            }
        }
        return l==r;
    }
    private void swap(int[]arr,int l,int r){
        while (l<r){
            int temp = arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            l++;
            r--;
        }
    }

    /**
     * 1460.翻转子数组使两个数组相等 2.0
     * 计数，直接对比数组是否一致
     * @param target
     * @param arr
     * @return
     */
    public boolean canBeEqual_2(int[] target, int[] arr){
        int[] cnt = new int[1001];
        for (int i=0;i<arr.length;i++){
            cnt[arr[i]]++;
            cnt[target[i]]--;
        }
        for (int n : cnt){
            if (n!=0)
                return false;
        }
        return true;
    }
}
