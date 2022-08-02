package com.alg.algorithms.leetcode.alg600;

public class Alg600 {
    /**
     * 593.有效的正方形
     * @param p1
     * @param p2
     * @param p3
     * @param p4
     * @return
     */
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        //任意三个点构成直角三角形
        return cal(p1,p2,p3) && cal(p1,p2,p4) && cal(p1,p3,p4) && cal(p2,p3,p4);
    }

    private boolean cal(int[]a , int[]b,int[]c){
        //判断是否在一个点上
        if (a[0]==b[0] && b[0]==c[0]) return false;
        int len1 = (a[0]-b[0])* (a[0]-b[0]) +  (a[1]-b[1]) *(a[1]-b[1]);
        int len2 = (a[0]-c[0])* (a[0]-c[0]) +  (a[1]-c[1]) *(a[1]-c[1]);
        int len3 = (c[0]-b[0])* (c[0]-b[0]) +  (c[1]-b[1]) *(c[1]-b[1]);
        if((len1==len2 && len1+len2==len3)||(len1==len3 && len1+len3==len2) || (len3==len2 && len3+len2==len1)){
            return true;
        }
        return false;
    }
}
