package com.alg.algorithms.alg400;

import java.util.ArrayList;
import java.util.List;

public class Alg320 {
    /**
     * 315.计算右侧小于当前元素的个数
     * 暴力求解，时间复杂度：O(N^2)
     * 执行超时
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int i=0;i<nums.length;i++){
            int cnt=0;
            for (int j=i+1;j<nums.length;j++){
                if (nums[i]>nums[j])
                    cnt++;
            }
            list.add(cnt);
        }
        return list;
    }
}
