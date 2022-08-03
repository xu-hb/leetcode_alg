package com.alg.algorithms.offer.alg50;

import java.util.*;

/**
 * 剑指offer2：1-10题
 */
public class Alg10 {
    /**
     * 3.数组中重复的数字
     * 时间复杂度：O(NlogN)
     * 空间复杂度：O(logN)
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i=1;i<nums.length;i++){
            if (nums[i]==nums[i-1])
                return nums[i];
        }
        return -1;
    }

    /**
     * 3.数组中重复的数字 2.0
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param nums
     * @return
     */
    public int findRepeatNumber_2(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i=0;i<nums.length;i++){
            if (set.contains(nums[i]))
                return nums[i];
            set.add(nums[i]);
        }
        return -1;
    }

    /**
     * 3.数组中重复的数字 3.0
     * 值作为索引
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param nums
     * @return
     */
    public int findRepeatNumber_3(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i=0;i<nums.length;i++){
            arr[nums[i]]+=1;
        }
        for (int i=0;i<nums.length;i++){
            if (arr[i]>1) return i;
        }
        return -1;
    }

    /**
     * 3.数组中重复的数字 4.0
     * 原数组上 值与索引互调
     * 时间复杂度：O(N)
     * 空间复杂度:O(1)
     * @param nums
     * @return
     */
    public int findRepeatNumber_4(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if(nums[i] == i) {
                i++;
                continue;
            }
            if(nums[nums[i]] == nums[i]) return nums[i];
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }
}