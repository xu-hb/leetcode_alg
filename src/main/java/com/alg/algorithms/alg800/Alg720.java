package com.alg.algorithms.alg800;

public class Alg720 {
    /**
     * 714.买卖股票的最佳时机含手续费
     * 贪心算法
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int buy = prices[0] + fee;
        int sum = 0;
        for (int p : prices) {
            if (p + fee < buy) {
                buy = p + fee;
            } else if (p > buy){
                sum += p - buy;
                buy = p;
            }
        }
        return sum;
    }
}
