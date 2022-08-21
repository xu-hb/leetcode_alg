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
     * 43.1~n整数中1出现的次数 2.0
     * 时间复杂度：O(logN)
     * @param n
     * @return
     */
    public int countDigitOne_2(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while(high != 0 || cur != 0) {
            if(cur == 0) res += high * digit;
            else if(cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }

    /**
     * 44.数字序列中某一位的数字
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        int digit = 1; //位数
        long start = 1;//开始范围第一个数
        long total = 9; //占用总位数
        while (n>total){
            n-=total;
            digit++;
            start*=10;
            total = digit * start * 9;
        }
        long num = start + (n-1)/digit;
        return String.valueOf(num).charAt((n-1)%digit)-'0';
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
