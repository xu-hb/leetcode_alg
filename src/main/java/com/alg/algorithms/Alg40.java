package com.alg.algorithms;

/**
 * 算法31-40
 */
public class Alg40 {
    /**
     * 31.下一个排列
     * 时间复杂度:O(N)
     * 空间复杂度:O(1)
     * @param nums
     */
    public void nextPermutation(int[] nums) {

        int cursor = nums.length -1;

        for (; cursor>0;cursor--){
            //第一次出现后值比前值大时
            if (nums[cursor] > nums[cursor-1]){
                int temp = nums[cursor-1];

                //遍历过的数组中不小于temp的最小值（此时是有序的，可以使用二分查找，此处为了简单）
                for (int j=nums.length-1;j>=cursor;j--){
                    if (nums[j]>temp){
                        //交换
                        nums[cursor-1] = nums[j];
                        nums[j]=temp;
                        break;
                    }
                }

                //cursor至末尾的数组升序值最小
                reverse(nums , cursor);
                return;
            }
        }

        //此时是最大队列，返回最小队列
        reverse(nums , 0);
    }

    /**
     * 31.下一个排列
     * 逻辑相同，代码简化
     * @param nums
     */
    public void nextPermutation_2(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    /**
     * 反转
     * @param nums
     * @param start
     */
    private void reverse(int[]nums , int start){
        int left = start,right = nums.length-1;
        while (left<right){
            swap(nums , left , right);
            left++;
            right--;
        }
    }

    /**
     * 交换
     * @param nums
     * @param i
     * @param k
     */
    private void swap(int[]nums , int i , int k){
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }
}
