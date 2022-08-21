package com.alg.algorithms.offer.alg50;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Alg50 {
    /**
     * 42.连续子数组的最大和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int sum=nums[0];
        int max=nums[0];
        for (int i=1;i< nums.length;i++){
            if (sum>0){
                sum+=nums[i];
            }else {
                sum=nums[i];
            }
            max = Math.max(max,sum);
        }
        return max;
    }

    /**
     * 43.1~n整数中1出现的次数
     * 超时
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        int prevCnt = 1;
        for (int i=2;i<=n;i++){
            prevCnt = prevCnt + number(i);
        }
        return prevCnt;
    }
    private int number(int n){
        int cnt = 0;
        while (n!=0){
            if (n%10==1)
                cnt++;
            n=n/10;
        }
        return cnt;
    }

    /**
     * 45.把数组排成最小的数
     * 时间复杂度：O(NlogN)
     * 空间复杂度：O(N)
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }

    /**
     * 50.第一个只出现一次的字符
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        if (Objects.equals(s, "")){
            return ' ';
        }

        int[] cnt = new int[26];
        for (int i=0;i<s.length();i++){
            cnt[s.charAt(i)-'a']++;
        }
        for (int i=0;i<s.length();i++){
            if (cnt[s.charAt(i)-'a']==1)
                return s.charAt(i);
        }
        return ' ';
    }
}
