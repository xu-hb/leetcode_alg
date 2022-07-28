package com.alg.algorithms.alg1400;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Alg1340 {
    /**
     * 1331.数组序号转换
     * @param arr
     * @return
     */
    public int[] arrayRankTransform(int[] arr) {
        int[] clone = arr.clone();
        Arrays.sort(clone);

        int idx = 1;
        Map<Integer , Integer> map = new HashMap<>(clone.length);
        for (int i=0;i<clone.length;i++){
            if (! map.containsKey(clone[i])){
                map.put(clone[i],idx++);
            }
        }
        for (int i=0;i<arr.length;i++){
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }

}
