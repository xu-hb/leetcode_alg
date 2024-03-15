package com.alg.algorithms.leetcode.alg500;

import com.alg.common.TreeNode;

import java.util.*;

public class Alg440 {

    /**
     * 435.无重叠区间
     * 贪心
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        //按end升序排序
        Arrays.sort(intervals , (o1, o2) -> {return o1[1]-o2[1];});
        int lastEnd = intervals[0][1];
        int count = 1;
        for (int i=1;i<n;i++){
            int start = intervals[i][0];
            //贪心：取end的最小值
            if (start>=lastEnd){
                count++;
                lastEnd = intervals[i][1];
            }
        }
        return n-count;
    }

    /**
     * 435.无重叠区间 2.0
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals_2(int[][] intervals) {
        int n = intervals.length;
        //按end升序排序
        Arrays.sort(intervals , (o1, o2) -> {return o1[1]-o2[1];});

        int[]dp = new int[n];
        dp[0]=0;
        int lastEnd = intervals[0][1];
        for (int i=1;i<n;i++){
            int start = intervals[i][0];
            if (start>=lastEnd){
                dp[i]=dp[i-1];
                lastEnd = intervals[i][1];
            }else {
                dp[i] = 1+dp[i-1];
            }
        }
        return dp[n-1];
    }

    /**
     * 437.路径总和III
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(N)
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;

        int ret = defSum(root , targetSum);
        ret += pathSum(root.left , targetSum);
        ret += pathSum(root.right , targetSum);
        return ret;
    }

    private int defSum(TreeNode root, long targetSum) {
        int ret = 0;
        if (root == null)
            return 0;
        if (targetSum == root.val){
            ret++;
        }

        ret += defSum(root.left , targetSum-root.val);
        ret += defSum(root.right , targetSum-root.val);

        return ret;
    }


    /**
     * 438.找到字符串中所有字母异位词
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        List<Integer> res = new ArrayList<>();
        if(sLen < pLen) return res;

        int[] pCnt = new int[26];
        int[] window = new int[26];

        for(int i = 0; i < pLen; i++){
            pCnt[p.charAt(i) - 'a'] ++;
        }

        int left=0,right=0;
        while (right<sLen){
            int curRight = s.charAt(right) - 'a';
            window[curRight]++;
            while (window[curRight]>pCnt[curRight]){
                int curLeft = s.charAt(left) - 'a';
                window[curLeft]--;
                left++;
            }
            if(right - left + 1 == pLen){
                res.add(left);
            }
            right++;
        }
        return res;
    }
}
