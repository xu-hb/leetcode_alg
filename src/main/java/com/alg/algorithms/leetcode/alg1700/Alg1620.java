package com.alg.algorithms.leetcode.alg1700;

import java.util.Arrays;

public class Alg1620 {
    /**
     * 1619.删除某些元素后的数组均值
     * 快排
     * 时间复杂度：O(NlogN)
     * 空间复杂度：O(logN)
     * @param arr
     * @return
     */
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int cnt = (arr.length * 5)/100;
        int sum=0;
        for (int i=0;i<arr.length;i++){
            if (i+1<=cnt || i+cnt>=arr.length) continue;
            sum +=arr[i];
        }
        return 1.0* sum / (arr.length-cnt*2);
    }
}
