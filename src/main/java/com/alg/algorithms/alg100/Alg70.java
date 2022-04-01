package com.alg.algorithms.alg100;

public class Alg70 {
    /**
     * 69. x的平方根
     * 二分查找
     * tag:BinarySearch
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int low=0,high=x,ans=-1;
        while (low<=high){
            int middle = (low+high)/2;
            long temp = (long) middle *middle;
            if (temp <=x){
                ans=middle;
                low=middle+1;
            }else {
                high=middle-1;
            }
        }
        return ans;
    }

}
