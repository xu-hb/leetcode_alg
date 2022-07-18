package com.alg.algorithms.alg600;

public class Alg510 {
    /**
     * 509.斐波那契数列 5.0
     * 4.0基础上简化dp数组多余空间
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
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

    /**
     * 509.斐波那契数列 3.0
     * 记忆化递归;二叉树转为线性
     * 时间复杂度：O(N)
     * 空间复杂度:O(N)
     * @param n
     * @return
     */
    public int fib_3(int n) {
        //初始化记忆数组
        mem = new int[n+1];
        for (int i=2;i<n+1;i++){
            mem[i] = -2;
        }
        return memRecursion(n);
    }
    //记忆数组
    int[] mem;
    private int memRecursion(int n){
        if (n<2) return n;
        //取出记录结果（剪枝）
        if (mem[n] != -2) return mem[n];

        int res = memRecursion(n-1)+memRecursion(n-2);
        //记录结果，防止重复计算
        mem[n]=res;
        return res;
    }

    /**
     * 509.斐波那契数列 4.0
     * 递归转迭代
     * 时间复杂度：O(N)
     * 空间复杂度:O(N)
     * @param n
     * @return
     */
    public int fib_4(int n) {
        if (n<2) return n;
        dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        return calculate(n);
    }
    //记忆化数组
    int[] dp;
    private int calculate(int n){
        if (n<2) return dp[n];
        //将3.0的线性递归优化为线性迭代
        for (int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
