package com.alg.algorithms.alg400;

import java.util.Arrays;
import java.util.Comparator;

public class Alg360 {
    /**
     * 354.俄罗斯套娃信封
     * error:
     * 思路：w升序排序，w相同时h升序排序。然后遍历比较后值比前值大并类推到结尾
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

    /**
     * 354.俄罗斯套娃信封 2.0
     * 该题与【最长递增子序列】相似，不过是一维升为二维。如能将其降维，则能转为【最长递增子序列】问题
     * 降维思路：w+h;w*h均不能正常降维。先将w升序，w相同时h降序排序，即可忽略w，将h数组和递增子序列同样逻辑
     * DP
     * @param envelopes
     * @return
     */
    public int maxEnvelopes_2(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //0：w升序；1：h降序
                //h降序是保证相同w下只能有一个值满足条件
                return o1[0]==o2[0] ? o2[1]-o1[1] : o1[0]-o2[0];
            }
        });
        int[] hArr = new int[envelopes.length];
        for (int i=0;i<envelopes.length;i++){
            //取出h
            hArr[i]=envelopes[i][1];
        }

        //最长递增子序列逻辑
        return lengthOfLIS(hArr);
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
