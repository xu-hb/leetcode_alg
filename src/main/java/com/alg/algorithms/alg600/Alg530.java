package com.alg.algorithms.alg600;

import java.util.Random;

public class Alg530 {
    Random random = null;
    int[] sum = null;
    public Alg530(int[] w) {
        sum = new int[w.length+1];
        for (int i=1;i<sum.length;i++){
            sum[i]=sum[i-1]+w[i-1];
        }
        random = new Random();
    }

    /**
     * 528.按权重随机选择
     * @return
     */
    public int pickIndex() {
        int max = sum[sum.length-1];
        int randomVal = random.nextInt(max);
        //二分查找
        int low=1,high= sum.length-1;
        while (low<=high){
            int middle = low+(high-low)/2;
            if (sum[middle]==randomVal){
                low= middle+1;
            }else if (sum[middle]<randomVal){
                low=middle+1;
            }else {
                high=middle-1;
            }
        }
        if (high>=sum.length) high= sum.length-1;
        return high;
    }

}
