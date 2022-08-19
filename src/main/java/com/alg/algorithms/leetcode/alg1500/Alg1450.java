package com.alg.algorithms.leetcode.alg1500;

public class Alg1450 {
    /**
     * 1450.在既定时间作业的学生人数
     * @param startTime
     * @param endTime
     * @param queryTime
     * @return
     */
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int cnt = 0;
        for (int i=0;i<startTime.length;i++){
            if (startTime[i]<=queryTime && endTime[i]>=queryTime){
                cnt++;
            }
        }
        return cnt;
    }
}
