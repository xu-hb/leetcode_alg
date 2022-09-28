package com.alg.algorithms.interview6;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Chapter17 {
    /**
     * 17.09 第k个数
     * error:out of memory limit
     * @param k
     * @return
     */
    public int getKthMagicNumber(int k) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        long last = -1;  //上一次弹出的值，重复值对比
        while (k>0){
            long val = queue.poll();
            if (val!=last) k--;
            last = val;
            queue.add(val*3);
            queue.add(val*5);
            queue.add(val*7);
        }
        return (int) last;
    }

    /**
     * 17.09 第k个数 2.0
     * 小根堆
     * 时间复杂度：O(NlogN)
     * 空间复杂度：O(N)
     * @param k
     * @return
     */
    public int getKthMagicNumber_2(int k){
        PriorityQueue<Long> queue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        int[] nums = new int[]{3,5,7};
        queue.add(1L);set.add(1L);

        while (! queue.isEmpty()){
            long val = queue.poll();
            if (--k==0) return (int) val;
            for (int n : nums){
                if (! set.contains(val*n)){
                    queue.add(val*n);
                    set.add(val*n);
                }
            }
        }
        return -1;
    }

}
