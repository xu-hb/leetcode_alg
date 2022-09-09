package com.alg.algorithms.leetcode.alg1500;

public class Alg1450 {

    /**
     * 1446.连续字符
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param s
     * @return
     */
    public int maxPower(String s) {
        int max = 0,cnt=0;
        int l=0,r=0;
        while (r<s.length()){
            if (s.charAt(l)==s.charAt(r)){
                cnt++;
                r++;
            }else {
                cnt=0;
                l=r;
            }
            max = Math.max(max , cnt);
        }
        return max;
    }

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
