package com.alg.algorithms.alg1400;

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
}
