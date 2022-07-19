package com.alg.algorithms.alg400;

import java.util.Arrays;
import java.util.Comparator;

public class Alg360 {
    /**
     * 354.俄罗斯套娃信封
     * error:
     * 思路：w降序排序，w相同时h降序排序。然后遍历比较后值比前值大并类推到结尾
     * 反例：(1,100),(2,1),(2,2)
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0] ? o1[1]-o2[1] : o1[0]-o2[0];
            }
        });

        int result = 1;
        int[] min = envelopes[0];
        for (int i=1;i<envelopes.length;i++){
            if (compare(envelopes[i],min)>0){
                min = envelopes[i];
                result++;
            }
        }
        return result;
    }
    private int compare(int[] envelope, int[] min) {
        if (envelope[0]>min[0] && envelope[1]>min[1]){
            return 1;
        }
        return -1;
    }

}
