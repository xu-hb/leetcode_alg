package com.alg.algorithms.alg500;

import com.alg.design.cache.LFUCache;

import java.util.Arrays;

public class Alg460 {

    /**
     * 452.用最少数量的箭引爆气球
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        //按end升序,不使用减法，防止越界
        Arrays.sort(points , (o1, o2) -> o1[1] < o2[1] ? -1 : 1);
        int lastEnd = points[0][1];
        int cnt = 1;    //不重叠区间:n个不重叠区间就需要n只箭->需要最少的箭就需最少的不重叠区间
        for (int i=1;i<n;i++){
            int start = points[i][0];
            //贪心：最少的不重叠区间->按右端点排序，区间右端最小的右端点处射箭，引爆气球最多
            if (start>lastEnd){
                cnt++;
                lastEnd = points[i][1];
            }
        }
        return cnt;
    }

    /**
     * 460.LFU缓存
     * @see com.alg.design.cache.LFUCache
     * @param capacity
     */
    public void LFUCache(int capacity) {
        LFUCache cache = new LFUCache(capacity);
    }
}
