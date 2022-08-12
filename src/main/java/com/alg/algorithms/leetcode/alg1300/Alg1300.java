package com.alg.algorithms.leetcode.alg1300;

import java.util.*;

public class Alg1300 {
    /**
     * 1282.用户分组
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param groupSizes
     * @return
     */
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i=0;i< groupSizes.length;i++){
            if (map.containsKey(groupSizes[i])){
                map.get(groupSizes[i]).add(i);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(groupSizes[i], list);
            }
        }
        List<List<Integer>> resList = new ArrayList<>(groupSizes.length);
        map.forEach((k,v)->{
            int len = v.size();
            if (len<=k){
                resList.add(v);
                return;
            }
            int idx=0;
            while (idx<len){
                List<Integer> list = new ArrayList<>();
                for (int i=0;i<k;i++){
                    list.add(v.get(idx+i));
                }
                resList.add(list);
                idx+=k;
            }
        });
        return resList;
    }
}
