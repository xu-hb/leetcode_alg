package com.alg.algorithms.alg600;

import com.alg.algorithms.alg1200.Alg1150;

public class Alg520 {
    /**
     * 516.最长回文子序列
     * DP
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        //dp：(i,j)串的最长回文子序列
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            //(i,i)自身回文长度1
            dp[i][i] = 1;
            char c1 = s.charAt(i);
            for (int j = i + 1; j < n; j++) {
                char c2 = s.charAt(j);
                if (c1 == c2) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    /**
     * 516.最长回文子序列 2.0
     * 转为最长公共子序列问题
     * @param s
     * @return
     */
    public int longestPalindromeSubseq_2(String s){
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        //字符串&字符串翻转，转换为最长公共子序列问题
        return new Alg1150().longestCommonSubsequence(s , sb.toString());
    }
}
