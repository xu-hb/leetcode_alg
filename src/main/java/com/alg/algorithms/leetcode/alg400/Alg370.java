package com.alg.algorithms.leetcode.alg400;

public class Alg370 {
    /**
     * 367.有效的完全平方数
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        int low=0;
        int high=num;
        while (low<=high){
            int middle = low + (high-low)/2;

            //防止溢出
            long temp = (long)middle*middle;
            if (temp==num){
                return true;
            }else if (temp<num){
                low=middle+1;
            }else {
                high=middle-1;
            }
        }
        return false;
    }
}
