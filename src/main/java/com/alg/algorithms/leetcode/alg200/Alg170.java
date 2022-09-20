package com.alg.algorithms.leetcode.alg200;

public class Alg170 {

    /**
     * 162.寻找峰值
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        for (int i=1;i<nums.length-1;i++){
            if (nums[i]>nums[i-1] && nums[i]>nums[i+1]){
                return i;
            }
        }
        //处理边界
        if (nums.length==1) return 0;
        if (nums.length>1){
            if (nums[0]>nums[1]) return 0;
            if (nums[nums.length-1]>nums[nums.length-2]) return nums.length-1;
        }
        return -1;
    }

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
