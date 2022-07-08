package com.alg.algorithms.alg1100;

import java.util.Arrays;

public class Alg1020 {
    /**
     * 1011.在D天内送达包裹的能力
     * @param weights
     * @param days
     * @return
     */
    public int shipWithinDays(int[] weights, int days) {
        //泛二分查找
        //运输能力下限：最大的单体包裹
        int low = Arrays.stream(weights).max().getAsInt();
        //运输能力上限：所有的包裹之和
        int high = Arrays.stream(weights).sum();
        while (low<=high){
            int needDays = 1;
            int sum = 0;

            int middle = low+(high-low)/2;
            for (int w : weights){
                if (sum+w>middle){
                    //一天运输和>当前运输能力，增加一天
                    needDays++;
                    sum=0;
                }
                sum+=w;
            }

            if (needDays>days){
                //当前middle运输能力下，需要天数>规定天数
                low=middle+1;
            }else if (needDays<days){
                high=middle-1;
            }else {
                high=middle-1;
            }
        }
        return low;
    }
}
