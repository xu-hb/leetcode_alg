package com.alg.algorithms.leetcode.alg1700;

public class Alg1690 {
    /**
     * 1688.比赛中的配对次数
     * 时间复杂度：O(logN)
     * 空间复杂度：O(1)
     * @param n
     * @return
     */
    public int numberOfMatches(int n) {
        int cnt = 0;
        while (n>1){
            if ((n&1)==1){
                //奇数
                n = (n-1)/2 + 1;
                cnt+=n-1;
            }else {
                //偶数
                n = n / 2;
                cnt+=n;
            }
        }
        return cnt;
    }
}
