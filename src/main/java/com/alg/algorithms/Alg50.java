package com.alg.algorithms;

import java.util.Arrays;

/**
 * 算法41-50
 */
public class Alg50 {
    /**
     * 43.字符串相乘
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(m+n)
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int m = num1.length();
        int n = num2.length();
        //乘积最大位数m+n
        int[] result = new int[m+n];

        for (int i=m-1; i>=0;i--){
            int x = num1.charAt(i)-'0';
            for (int k=n-1; k>=0; k--){
                int y = num2.charAt(k) - '0';
                //竖式乘积和
                result[i+k+1] += x*y;
            }
        }

        //进位
        for (int k = result.length-1; k>=0;k--){
            int val = result[k];
            if (val>=10){
                result[k-1] += val/10;
                result[k] = val%10;
            }
        }
        //高位去0
        int cursor = result[0] ==0 ? 1 : 0;
        StringBuilder sb = new StringBuilder();
        for (;cursor<result.length;cursor++){
            sb.append(result[cursor]);
        }

        return sb.toString();
    }
}
