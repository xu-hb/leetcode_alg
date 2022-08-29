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

    /**
     * 1470.重新排列数组
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param nums
     * @param n
     * @return
     */
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
        int idx=0;
        for (int i=0;i<n;i++){
            ans[idx++] = nums[i];
            ans[idx++] = nums[i+n];
        }
        return ans;
    }
}
