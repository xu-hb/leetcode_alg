package com.alg.algorithms.alg400;

import java.util.Arrays;

public class Alg330 {
    /**
     * 322.零钱兑换
     * 记忆化搜索
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount){
        dp = new int[amount+1];
        return cal(coins,amount);
    }
    int[] dp;
    private int cal(int[] coins, int amount) {
        if (amount==0) return 0;
        if (amount<0) return -1;
        if (dp[amount] !=0) return dp[amount];

        int min = Integer.MAX_VALUE;
        for (int c : coins){
            int res = cal(coins , amount-c);
            if (res==-1) continue;
            min = Math.min(min , res+1);
        }
        dp[amount]=min==Integer.MAX_VALUE?-1:min;
        return dp[amount];
    }
}
