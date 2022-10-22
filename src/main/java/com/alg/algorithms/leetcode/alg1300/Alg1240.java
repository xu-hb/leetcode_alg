package com.alg.algorithms.leetcode.alg1300;

import java.util.Arrays;

public class Alg1240 {
    /**
     * 1235.规划兼职工作
     * DP
     * 时间复杂度：O(NlogN)
     * 空间复杂度：O(N)
     * @param startTime
     * @param endTime
     * @param profit
     * @return
     */
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n= endTime.length;
        int[][] jobs = new int[n][];
        for (int i=0;i<n;i++){
            jobs[i] = new int[]{startTime[i],endTime[i],profit[i]};
        }
        //结束时间升序排列
        Arrays.sort(jobs,(a,b)->a[1]-b[1]);

        //dp:前i份工作能获取的最大报酬
        int[]dp = new int[n+1];
        dp[0]=0;
        for (int i=1;i<=n;i++){
            //二分查找<startTime[i-1]的最大endTime工作的薪酬
            int l = search(jobs , i-1 , jobs[i-1][0]);
            //递推：第i-1工作要么选择，要么放弃。
            dp[i] = Math.max(dp[i-1],dp[l]+jobs[i-1][2]);
        }
        return dp[n];
    }

    public int search(int[][] jobs, int right, int target) {
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid][1] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
