package com.alg.algorithms.alg400;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Alg350 {
    /**
     * 349.两个数组的交集
     * 时间复杂度：O(n+m)
     * 空间复杂度：O(min(m,m))
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();

        Set<Integer> set = new HashSet<>();
        for (int n : nums1){
            set.add(n);
        }
        for (int n : nums2){
            if (set.contains(n))
                result.add(n);
        }
        int[] temp = new int[result.size()];
        int i=0;
        for (int n : result){
            temp[i]=n;
            i++;
        }
        return temp;
    }
}
