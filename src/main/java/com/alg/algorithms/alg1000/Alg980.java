package com.alg.algorithms.alg1000;

public class Alg980 {
    /**
     * 977.有序的数组的平方
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int low=0;
        int high=nums.length-1;
        int cursor = nums.length-1;

        while (low<=high){
            if (Math.abs(nums[low])<Math.abs(nums[high])){
                result[cursor]=nums[high] * nums[high];
                high--;
            }else {
                result[cursor]=nums[low] * nums[low];
                low++;
            }
            cursor--;
        }
        return result;
    }
}
