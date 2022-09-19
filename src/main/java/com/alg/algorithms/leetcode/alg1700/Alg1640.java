package com.alg.algorithms.leetcode.alg1700;

import java.util.*;
import java.util.stream.Collectors;

public class Alg1640 {

    /**
     * 1636.按照频率将数组升序排序
     * 时间复杂度：O(NlogN)
     * 空间复杂度：O(N)
     * @param nums
     * @return
     */
    public int[] frequencySort(int[] nums) {
        //k:v->num:cnt
        Map<Integer, Integer> cnt = new HashMap<>();
        //赋值频次
        for (int n : nums){
            cnt.put(n,cnt.getOrDefault(n,0)+1);
        }

        List<Integer> list = Arrays.stream(nums).boxed().sorted((a, b) ->
                //频率相同按值本身降序
             cnt.get(a).equals(cnt.get(b)) ? b-a : cnt.get(a)-cnt.get(b)
        ).collect(Collectors.toList());

        int[] ret = new int[nums.length];
        for (int i=0;i<list.size();i++){
            ret[i] = list.get(i);
        }
        return ret;
    }
}
