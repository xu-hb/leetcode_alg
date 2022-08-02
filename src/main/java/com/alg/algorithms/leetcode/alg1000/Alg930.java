package com.alg.algorithms.leetcode.alg1000;

public class Alg930 {
    /**
     * 922.按奇偶排序数组II
     * 时间复杂度：O(N)
     * 空间复杂度:O(1)
     * @param nums
     * @return
     */
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        //奇数、偶数索引
        int evenIdx = 0,fast=1;
        while (fast<n){
            //奇数
            if (fast%2==1 && nums[fast]%2!=1){
                while (evenIdx<n){
                    if (nums[evenIdx] %2==1){
                        int temp = nums[fast];
                        nums[fast] = nums[evenIdx];
                        nums[evenIdx] = temp;
                        break;
                    }
                    evenIdx+=2;
                }
            }
            fast++;
        }
        return nums;
    }

    /**
     * 922.按奇偶排序数组II 2.0
     * 逻辑优化&代码简化
     * @param nums
     * @return
     */
    public int[] sortArrayByParityII_2(int[] nums) {
        int evenIdx=0;//偶数索引
        //遍历奇数位
        for (int i=1;i<nums.length;i+=2){
            if ((nums[i]&1)==0){
                while ((nums[evenIdx]&1)==0){
                    //寻找偶数位为奇数的索引
                    evenIdx+=2;
                }
                int temp = nums[i];
                nums[i] = nums[evenIdx];
                nums[evenIdx] = temp;
            }
        }
        return nums;
    }
}
