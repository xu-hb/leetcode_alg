package com.alg.algorithms.leetcode.alg400;

import java.util.HashSet;
import java.util.Set;

public class Alg350 {

    /**
     * 343.整数拆分
     * DP
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[2]=1;

        for (int i=3;i<=n;i++){
            for (int j=1;j<i;j++){
                //dp[i]来源有两种：1.拆分为2个：j*(i-j);2.拆分为2个以上:j*dp[i-j]
                dp[i] = Math.max(dp[i] , Math.max(j*dp[i-j] , j*(i-j)));
            }
        }

        return dp[n];
    }

    /**
     * 344.反转字符串
     * @param s
     */
    public void reverseString(char[] s) {
        int left=0,right=s.length-1;
        while (left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

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
