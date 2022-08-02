package com.alg.algorithms.leetcode.alg200;

public class Alg130 {
    /**
     * 122.买卖股票的最佳时机II
     * 回溯
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length==1)
            return 0;
        int maxProfit=0;
        //贪心：贪心每天的正利润
        //假设：第i天买,k天卖(k>i)。此时段的利润：p[k]-p[i]等价于(p[k]-p[k-1])+(p[k-1]-p[k-2])+...+(p[i+1]-p[i])
        int[] profile = new int[prices.length-1];
        for (int i=1;i<prices.length;i++){
            int temp = prices[i]-prices[i-1];
            profile[i-1]=temp;
            if (temp>0){
                maxProfit+=temp;
            }
        }
        return maxProfit;
    }
}
