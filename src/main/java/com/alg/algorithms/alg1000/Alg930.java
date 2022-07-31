package com.alg.algorithms.alg1000;

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
        int oddIdx=1,evenIdx = 0,fast=1;
        while (fast<n){
            //偶数
            if (fast%2==0 && nums[fast]%2 !=0){
                //和奇数位上的偶数对调
                while (oddIdx<n){
                    if (nums[oddIdx]%2==0){
                        int temp = nums[fast];
                        nums[fast]=nums[oddIdx];
                        nums[oddIdx] = temp;
                        break;
                    }
                    oddIdx+=2;
                }
            }
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
}
