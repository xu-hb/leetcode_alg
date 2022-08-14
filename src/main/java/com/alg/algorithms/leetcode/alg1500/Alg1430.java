package com.alg.algorithms.leetcode.alg1500;

public class Alg1430 {
    /**
     * 1422.分割字符串的最大得分
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param s
     * @return
     */
    public int maxScore(String s) {
        int cntZero = 0,cntOne=0;
        for (int i=0;i<s.length();i++){
            if ('0'==s.charAt(i))
                cntZero++;
        }
        cntOne=s.length()-cntZero;
        int max = 0;
        int cntL=0,cntR=cntOne;
        for (int i=0;i<s.length()-1;i++){
            if ('0'==s.charAt(i)){
                cntL++;
            }else {
                cntR--;
            }
            max = Math.max(max,cntL+cntR);
        }
        return max;
    }
}
