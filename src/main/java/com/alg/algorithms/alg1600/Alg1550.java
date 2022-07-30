package com.alg.algorithms.alg1600;

public class Alg1550 {
    /**
     * 1550.存在连续三个奇数的数组
     * @param arr
     * @return
     */
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        if (n<3) return false;
        int low=-1;
        int high=0;
        int mask = 1;
        for (int i=0;i<n;i++){
            if ((arr[i] & mask)==1){
                //奇数
                high=i;
            }else {
                low=i;
            }
            if (high-low>=3){
                return true;
            }
        }
        return false;
    }

    /**
     * 1550.存在连续三个奇数的数组
     * 代码优化
     * @param arr
     * @return
     */
    public boolean threeConsecutiveOdds_2(int[] arr) {
        byte mask = 1;
        int cnt = 0;
        for (int n : arr){
            if ((n & mask) ==1)
                cnt++;
            else
                cnt=0;
            if (cnt==3)
                return true;
        }
        return false;
    }
}
