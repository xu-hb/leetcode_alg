package com.alg.algorithms.alg500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Alg450 {
    /**
     * 454.四数相加
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(N^2)
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result = 0;
        Map<Integer , Integer> map= new HashMap<>();

        //map存储<和,数量>
        for (int i=0;i< nums1.length;i++){
            for (int j=0;j<nums2.length;j++){
                int sum = nums1[i]+nums2[j];
                map.put(sum,map.getOrDefault(sum , 0)+1);
            }
        }

        for (int i=0;i< nums3.length;i++){
            for (int j=0;j<nums4.length;j++){
                int sum = nums3[i]+nums4[j];
                if (map.containsKey(-sum)){
                    result+=map.get(-sum);
                }
            }
        }

        return result;
    }

    /**
     * 455.分发饼干
     * 贪心算法
     * 时间复杂度：O(mLogM+nlogN) 快排的复杂度
     * 空间复杂度：O(logM+logN)
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        //孩子、饼干游标
        int child = 0;
        int cookie = 0;
        for (;cookie<s.length && child<g.length;cookie++){
            if (s[cookie]>=g[child]) child++;
        }
        return child;
    }
}
