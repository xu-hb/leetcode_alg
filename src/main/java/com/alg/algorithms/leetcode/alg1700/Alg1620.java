package com.alg.algorithms.leetcode.alg1700;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

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

    /**
     * 1619.删除某些元素后的数组均值 2.0
     * 大根堆+小根堆
     * 时间复杂度：O(NlogK)
     * 空间复杂度：O(K)
     * @param arr
     * @return
     */
    public double trimMean_2(int[] arr){
        int cnt = (arr.length * 5)/100;
        //小根堆：存放后cnt个最大值
        Queue<Integer> minQue = new PriorityQueue<>(cnt);
        //大根堆：存放前cnt个最小值
        Queue<Integer> maxQue = new PriorityQueue<>(cnt , (v1,v2)-> v2-v1);

        int sum=0;
        int cur=0;
        //初始化堆
        for (;cur<cnt;cur++){
            sum+=arr[cur];
            minQue.add(arr[cur]);
        }

        while (cur<arr.length){
            int v = arr[cur];
            sum+=v;
            if (arr[cur] > minQue.peek()){
                //当前值更大，推入小根堆
                v = minQue.poll();
                minQue.offer(arr[cur]);
            }
            //推入大根堆
            if (maxQue.size()<cnt)
                maxQue.offer(v);
            else if (v<maxQue.peek()){
                maxQue.poll();
                maxQue.offer(v);
            }

            cur++;
        }

        //减去两端最值
        for (int v : minQue){
            sum-=v;
        }
        for (int v : maxQue){
            sum-=v;
        }

        return 1.0* sum / (arr.length-cnt*2);
    }
}
