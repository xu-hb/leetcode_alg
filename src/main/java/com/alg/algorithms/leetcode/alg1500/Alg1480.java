package com.alg.algorithms.leetcode.alg1500;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

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

    /**
     * 1475.商品折扣后的最终价格 2.0
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param prices
     * @return
     */
    public int[] finalPrices_2(int[] prices){
        int[] ret = new int[prices.length];

        Stack<Integer> stack = new Stack<>();
        for (int i=prices.length-1;i>=0;i--){
            while (! stack.isEmpty() && stack.peek()>prices[i]){
                stack.pop();
            }
            ret[i] = stack.isEmpty() ? prices[i] : prices[i]-stack.peek();
            stack.push(prices[i]);
        }

        return ret;
    }
}
