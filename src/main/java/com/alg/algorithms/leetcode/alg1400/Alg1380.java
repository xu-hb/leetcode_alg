package com.alg.algorithms.leetcode.alg1400;

public class Alg1380 {
    /**
     * 1374.生成每种字符都是奇数个的字符串
     * @param n
     * @return
     */
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        if ((n&1)==1) count=n;
        if ((n&1)==0) count=n-1;

        for (int i=0;i<count;i++){
            sb.append("a");
        }
        for (int j=count;j<n;j++){
            sb.append("b");
        }
        return sb.toString();
    }

    /**
     * 1374.生成每种字符都是奇数个的字符串 2.0
     * 代码优化
     * @param n
     * @return
     */
    public String generateTheString_2(int n){
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<n-1;i++){
            sb.append("a");
        }
        if ((n&1)==0){
            sb.append("b");
        }else {
            sb.append("a");
        }
        return sb.toString();
    }
}
