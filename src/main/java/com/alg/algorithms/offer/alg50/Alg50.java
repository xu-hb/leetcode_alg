package com.alg.algorithms.offer.alg50;

import java.util.Arrays;
import java.util.Comparator;

public class Alg50 {
    /**
     * 42.连续子数组的最大和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int sum=nums[0];
        int max=nums[0];
        for (int i=1;i< nums.length;i++){
            if (sum>0){
                sum+=nums[i];
            }else {
                sum=nums[i];
            }
            max = Math.max(max,sum);
        }
        return max;
    }

    /**
     * 45.把数组排成最小的数
     * 时间复杂度：O(NlogN)
     * 空间复杂度：O(N)
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }
}
