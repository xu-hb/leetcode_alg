package com.alg.algorithms.leetcode.alg800;

public class Alg750 {
    /**
     * 746.使用最小花费爬楼梯
     * DP
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) {
            return cost[0];
        }
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        //最后一步，如果是由倒数第二步爬，则最后一步的体力花费可以不用算
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}
