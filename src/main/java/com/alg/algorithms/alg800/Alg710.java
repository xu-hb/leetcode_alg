package com.alg.algorithms.alg800;

public class Alg710 {
    /**
     * 704.二分查找
     * 时间复杂度：O(logN)
     * 空间复杂度：O(1)
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (null==nums || nums.length==0) return -1;
        int left=0;
        int right=nums.length-1;

        while (left<=right){
            int middle = (left+right)/2;
            if (nums[middle] == target){
                return middle;
            }else if (nums[middle] < target){
                left = middle+1;
            }else {
                right = middle-1;
            }
        }
        return -1;
    }
}
