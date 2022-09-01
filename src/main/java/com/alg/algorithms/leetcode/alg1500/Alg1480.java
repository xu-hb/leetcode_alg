package com.alg.algorithms.leetcode.alg1500;

public class Alg1480 {
    /**
     * 1475.商品折扣后的最终价格
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(N)
     * @param prices
     * @return
     */
    public int[] finalPrices(int[] prices) {
        int[] ret = new int[prices.length];
        for (int i=0;i< prices.length;i++){
            ret[i] = prices[i];
            for (int j=i+1;j< prices.length;j++){
                if (prices[j]<=prices[i]){
                    ret[i]=prices[i]-prices[j];
                    break;
                }
            }
        }
        return ret;
    }
}
