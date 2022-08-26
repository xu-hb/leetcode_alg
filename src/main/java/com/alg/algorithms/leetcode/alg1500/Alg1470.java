package com.alg.algorithms.leetcode.alg1500;

public class Alg1470 {
    /**
     * 1464.数组中两个元素的最大值
     * 时间复杂度：O(N)
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int a = -1,b=-1;
        for (int n: nums){
            if (n>a){
                int temp=a;
                a=n;
                b=temp;
            }else if (n>b){
                b=n;
            }
        }
        return (a-1)*(b-1);
    }
}
