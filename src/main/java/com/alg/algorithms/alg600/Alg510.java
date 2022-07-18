package com.alg.algorithms.alg600;

public class Alg510 {
    /**
     * 509.斐波那契数列
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int F0 = 0, F1 = 0, result = 1;
        for (int i = 2; i <= n; ++i) {
            F0 = F1;
            F1 = result;
            result = F0 + F1;
        }
        return result;
    }

    /**
     * 509.斐波那契数列 2.0
     * 暴力递归
     * 时间复杂度:O(2^N)
     * @param n
     * @return
     */
    public int fib_2(int n) {
        if (n<2) return n;
        return fib_2(n-1)+fib_2(n-2);
    }

}
