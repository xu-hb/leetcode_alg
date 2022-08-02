package com.alg.algorithms.leetcode.alg700;

import java.util.Arrays;

public class Alg670 {
    /**
     * 670.最大交换
     * @param num
     * @return
     */
    public int maximumSwap(int num) {
        char[] origin = String.valueOf(num).toCharArray();
        char[] sorted = String.valueOf(num).toCharArray();
        int n = sorted.length;
        Arrays.sort(sorted);
        int i=0,j=n-1;
        for (;i<n;i++,j--){
            if (origin[i] !=sorted[j]){
                break;
            }
        }
        if (i<n){
            char temp = origin[i];
            origin[i]=sorted[j];
            for (int k=n-1;k>=0;k--){
                if (origin[k]==sorted[j]){
                    origin[k]=temp;
                    break;
                }
            }
        }
        return Integer.parseInt(String.valueOf(origin));
    }
}
