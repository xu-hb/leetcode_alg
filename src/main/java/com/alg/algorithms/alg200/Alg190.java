package com.alg.algorithms.alg200;

import java.util.*;

public class Alg190 {
    /**
     * 187.重复的DNA序列
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        int L = 10;
        Map<String , Integer> map = new HashMap<>();
        int left=0;
        for (;left<=s.length()-L;left++){
            String sub = s.substring(left,left+L);
            map.put(sub,map.getOrDefault(sub,0)+1);
        }
        map.forEach((key,val)->{
            if (val>1){
                result.add(key);
            }
        });
        return result;
    }
}
