package com.alg.algorithms.alg200;

public class Alg170 {
    /**
     * 167.两数之和II-输入有序数组
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int slow = 0,fast=1;
        while (fast< numbers.length){
            int sum = numbers[slow]+numbers[fast];
            if (sum==target){
                return new int[]{slow+1,fast+1};
            }else if (sum>target || fast+1== numbers.length){
                slow++;
                fast=slow;
            }
            fast++;
        }
        return new int[]{-1,-1};
    }

    /**
     * 167.两数之和II
     * 双指针+二分查找
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum_2(int[] numbers, int target){
        int left=0,right= numbers.length-1;
        while (left<right){
            int sum = numbers[left]+numbers[right];
            if (sum==target){
                return new int[]{left+1,right+1};
            }else if (sum>target){
                right--;
            }else {
                left++;
            }
        }
        return new int[]{-1,-1};
    }
}
