package com.alg.algorithms.alg100;

public class Alg70 {

    /**
     * 62.不同路径
     * DP
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i=0;i<n;i++){
            dp[0][i]=1;
        }
        for (int j=0;j<m;j++){
            dp[j][0]=1;
        }

        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * 63.不同路径II
     * DP
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0]==1) return 0;

        int[][] dp = new int[m][n];
        dp[0][0]=1;
        for (int i=1;i<n;i++){
            if (dp[0][i-1]==0 || obstacleGrid[0][i]==1){
                dp[0][i]=0;
            }else {
                dp[0][i]=1;
            }
        }
        for (int j=1;j<m;j++){
            if (dp[j-1][0]==0 || obstacleGrid[j][0]==1){
                dp[j][0]=0;
            }else {
                dp[j][0]=1;
            }
        }

        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                if (obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[m-1][n-1];
    }

    /**
     * 63.不同路径II 2.0
     * 代码优化
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles_2(int[][] obstacleGrid){
        if (obstacleGrid[0][0]==1) return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for (int i=0;i<n;i++){
            if (obstacleGrid[0][i]==1) break;   //后续均为0
            dp[0][i]=1;
        }
        for (int j=1;j<m;j++){
            if (obstacleGrid[j][0]==1) break;
            dp[j][0]=1;
        }

        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                if (obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[m-1][n-1];
    }

    /**
     * 69. x的平方根
     * 二分查找
     * tag:BinarySearch
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int low=0,high=x,ans=-1;
        while (low<=high){
            int middle = (low+high)/2;
            long temp = (long) middle *middle;
            if (temp <=x){
                ans=middle;
                low=middle+1;
            }else {
                high=middle-1;
            }
        }
        return ans;
    }

    /**
     * 70.爬楼梯
     * DP
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n<=2) return n;
        int F1=1;
        int F2=2;
        int sum=0;
        for (int i=3;i<=n;i++){
            sum = F1+F2;
            F1=F2;
            F2=sum;
        }
        return sum;
    }
}
