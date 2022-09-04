package com.alg.algorithms.leetcode.alg1600;

public class Alg1590 {
    /**
     * 1582.二进制矩阵中的特殊位置
     * 时间复杂度：O(n*m)
     * 空间复杂度：O(n+m)
     * @param mat
     * @return
     */
    public int numSpecial(int[][] mat) {
        int n = mat.length,m=mat[0].length;
        int[] row = new int[n];
        int[] col = new int[m];

        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                row[i]+=mat[i][j];
                col[j]+=mat[i][j];
            }
        }

        int ret=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (mat[i][j]==1 && row[i]==1 && col[j]==1) ret++;
            }
        }
        return ret;
    }
}
