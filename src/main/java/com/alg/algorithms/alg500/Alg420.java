package com.alg.algorithms.alg500;

import java.util.Arrays;

public class Alg420 {
    /**
     * 416.分割等和子集
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        //奇数，不可能等分
        if (sum%2==1) return false;

        return bag(nums , sum/2);
    }

    private boolean bag(int[] nums, int sum) {
        //dp:i-第i个物品;j-包空间
        boolean[][] dp = new boolean[nums.length+1][sum+1];
        for (int i=0;i<=nums.length;i++){
            //背包没有空间，则装满了
            dp[i][0] = true;
        }
        for (int i=1;i<= nums.length;i++){
            for (int j=1;j<=sum;j++){
                if (j-nums[i-1]>=0){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }else {
                    //放不下
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length][sum];
    }
}
