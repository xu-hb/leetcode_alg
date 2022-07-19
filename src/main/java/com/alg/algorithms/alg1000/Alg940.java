package com.alg.algorithms.alg1000;

import java.util.Arrays;

public class Alg940 {
    /**
     * 931.下降路径最小和
     * DP
     * @param matrix
     * @return
     */
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][]dp = new int[n][m];

        //初始化dp
        for (int i=0;i<m;i++){
            dp[0][i] = matrix[0][i];
        }

        for (int i=1;i<n;i++){
            for (int j=0;j<m;j++){
                int min = Integer.MAX_VALUE;
                //寻找前一行中下降路径的最小值
                for (int k=Math.max(j-1,0);k>=0&&k<m&&k<=j+1;k++){
                    min = Math.min(min , dp[i-1][k]);
                }
                dp[i][j] = min+matrix[i][j];
            }
        }
        return Arrays.stream(dp[n-1]).min().getAsInt();
    }
}
