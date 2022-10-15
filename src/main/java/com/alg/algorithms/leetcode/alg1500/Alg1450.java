package com.alg.algorithms.leetcode.alg1500;

import java.util.ArrayList;
import java.util.List;

public class Alg1450 {

    /**
     * 1441.用栈操作构建数组
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param target
     * @param n
     * @return
     */
    public List<String> buildArray(int[] target, int n) {
        int tail = target[target.length-1];
        n = Math.min(tail,n);

        String push = "Push";
        String pop = "Pop";
        List<String> ret = new ArrayList<>();

        int cur=0;
        int tIdx=0;
        while (cur<n){
            if (target[tIdx]==cur+1){
                ret.add(push);
                tIdx++;
            }else {
                ret.add(push);
                ret.add(pop);
            }
            cur++;
        }

        return ret;
    }

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
