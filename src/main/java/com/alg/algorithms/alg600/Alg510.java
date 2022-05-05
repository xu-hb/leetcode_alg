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


}
