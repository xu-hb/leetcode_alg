package com.alg.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 算法0-10
 */
public class Alg10 {
    /**
     * 1.两数之和
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target){
        for (int i=0; i<nums.length; i++){
            for (int j=i+1; j<nums.length; j++){
                if (nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    /**
     * 1.两数之和
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_2(int[] nums, int target){
        //数据存储到map中
        Map<Integer , Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            map.put(nums[i],i);
        }

        for (int i=0; i<nums.length; i++){
            int value = target - nums[i];
            Integer index = map.get(value);
            if (Objects.nonNull(index) && index!=i){
                return new int[]{i , index};
            }
        }
        return null;
    }
}
