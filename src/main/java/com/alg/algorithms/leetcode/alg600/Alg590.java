package com.alg.algorithms.leetcode.alg600;

public class Alg590 {
    /**
     * 583.两个字符串的删除操作
     * DP
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];

        dp[0][0]=0;
        for (int i=1;i<=n;i++){
            dp[i][0]=i;
        }
        for (int j=1;j<=m;j++){
            dp[0][j]=j;
        }

        for (int i=1;i<=n;i++){
            char c1 = word1.charAt(i-1);
            for (int j=1;j<=m;j++){
                char c2 = word2.charAt(j-1);
                if (c1==c2){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = 1+ Math.min(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}
