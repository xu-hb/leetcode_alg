package com.alg.algorithms.leetcode.alg6300;

public class Alg6210 {
    /**
     * 6208.有效时间的数目
     * 时间复杂度：O(C)
     * 空间复杂度：O(1)
     * @param time
     * @return
     */
    public static int countTime(String time) {
        int m=1,n=1;
        char c0=time.charAt(0);
        char c1=time.charAt(1);
        if (c0=='?'){
            m=c1=='?' ? 24 : c1>'3'? 2 : 3;
        }else {
            m=c1=='?' ? c0<'2' ? 10 : 4 : 1;
        }

        c0=time.charAt(3);
        c1=time.charAt(4);
        if (c1=='?'){
            n=c0=='?' ? 60 : 10;
        }else {
            n=c0=='?' ? 6 : 1;
        }

        return m*n;
    }
}
