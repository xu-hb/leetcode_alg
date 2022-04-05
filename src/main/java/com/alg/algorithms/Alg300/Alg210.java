package com.alg.algorithms.Alg300;

public class Alg210 {
    /**
     * 209.长度最小的子数组
     * 暴力求解
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        //设置为最大值
        int count = nums.length+1;
        int low=0;
        while (low<=nums.length-1){
            int high=low;
            int temp=0;
            while (high<nums.length){
                temp+=nums[high];
                if (temp>=target){
                    //取最小值
                    count = Math.min(count , high-low+1);
                    break;
                }
                high++;
            }
            low++;
        }
        if (count==nums.length+1) return 0;
        return count;
    }

    /**
     * 209.长度最小的子数组
     * 滑动窗口
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen_2(int target, int[] nums){
        int low=0,high=0;
        int min = Integer.MAX_VALUE;
        int sum=0;
        while (high<nums.length){
            sum+=nums[high];
            while (sum>=target){
                min = Math.min(min , high-low+1);
                sum-= nums[low];
                low++;
            }
            high++;
        }
        if (min==Integer.MAX_VALUE) return 0;
        return min;
    }
}
