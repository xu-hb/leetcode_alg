package com.alg.algorithms.leetcode.alg1600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Alg1510 {
    /**
     * 1403.非递增顺序的最小子序列
     * 时间复杂度：O(NlogN)
     * 空间复杂度: O(logN)
     * @param nums
     * @return
     */
    public List<Integer> minSubsequence(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int cal=0;
        for (int i=nums.length-1;i>=0;i--){
            cal+=nums[i];
            list.add(nums[i]);
            if (cal*2 > sum){
                return list;
            }
        }
        return list;
    }
}
