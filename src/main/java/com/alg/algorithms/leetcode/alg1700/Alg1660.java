package com.alg.algorithms.leetcode.alg1700;

import com.alg.design.stream.OrderedStream;

public class Alg1660 {

    /**
     * 1652.拆炸弹
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param code
     * @param k
     * @return
     */
    public int[] decrypt(int[] code, int k) {
        if (k==0){
            return new int[code.length];
        }

        int[] ret = new int[code.length];
        //方向
        int direction = k>0 ? 1 : -1;
        for (int i=0;i<code.length;i++){
            int sum=0;
            for (int j=0;j<k*direction;j++){
                int idx = (i+direction+j*direction+code.length)%code.length;
                sum += code[idx];
            }
            ret[i]=sum;
        }
        return ret;
    }

    /**
     * 1656.设计有序流
     * @see OrderedStream
     * @return
     */
    public OrderedStream orderedStream(){
        return new OrderedStream(5);
    }
}
