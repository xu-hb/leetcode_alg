package com.alg.algorithms.offer.alg50;

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


}
