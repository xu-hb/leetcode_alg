package com.alg.algorithms;

import com.alg.algorithms.common.ListNode;

import java.util.*;

/**
 * 算法0-10
 */
public class Alg10 {
    /**
     * 1.两数之和
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target){
        for (int i=0; i<nums.length; i++){
            for (int j=i+1; j<nums.length; j++){
                if (nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    /**
     * 1.两数之和
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_2(int[] nums, int target){
        //数据存储到map中
        Map<Integer , Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            map.put(nums[i],i);
        }

        for (int i=0; i<nums.length; i++){
            int value = target - nums[i];
            Integer index = map.get(value);
            if (Objects.nonNull(index) && index!=i){
                return new int[]{i , index};
            }
        }
        return null;
    }

    /**
     * 2.两数相加
     * 时间复杂度：O(max(l1.size,l2.size))
     * 空间复杂度：O(1)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode cursor = result;
        //两数和的十分位的数值
        int deciles = 0;
        while (l1 !=null || l2 !=null || deciles !=0){
            int l1val = l1 != null ? l1.val : 0;
            int l2val = l2 != null ? l2.val : 0;
            int sum = l1val + l2val + deciles;
            //求和的新节点
            ListNode node = new ListNode(sum % 10);
            cursor.next = node;
            cursor = node;
            //计算十分位值
            deciles = sum / 10;

            if (l1 !=null) l1 = l1.next;
            if (l2 !=null) l2 = l2.next;
        }
        //去除头结点
        return result.next;
    }

    /**
     * 3.无重复字符的最长子串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int rk = 0; //右指针
        int maxLength = 0;
        //存储头指针遍历后无重复的字符
        Set<Character> set = new HashSet<>();
        for (int i=0; i<s.length(); i++){
            if (i!=0){
                set.remove(s.charAt(i-1));
            }
            //指针向右移动
            while (rk<s.length() && !set.contains(s.charAt(rk))){
                set.add(s.charAt(rk));
                rk++;
            }
            maxLength = Math.max(maxLength , rk-i);
        }
        return maxLength;
    }

    /**
     * 5.最长回文子串
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int start = 0, end=0;
        for (int i=0; i<s.length(); i++){
            int len1 = calculateLength(s , i ,i);
            int len2 = calculateLength(s, i , i+1);
            int len = Math.max(len1 , len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }

        }
        return s.substring(start, end + 1);
    }

    /**
     * 6.Z字形变换
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows ==1 || numRows>=s.length()){
            return s;
        }
        //存储各行的字符
        StringBuffer[] buf = new StringBuffer[numRows];
        for (int i=0; i<numRows; i++){
            buf[i] = new StringBuffer();
        }

        int cursor=0;
        int t = 2* numRows -2;
        for (int i=0; i<s.length(); i++){
            buf[cursor].append(s.charAt(i));
            //Z字形的规律，每一个周期为2*n-2,取模后不小于n-1的为斜线上的数据
            if (i%t < numRows-1){
                ++cursor;
            }else {
                --cursor;
            }
        }

        StringBuffer result = new StringBuffer();
        for (StringBuffer sb : buf){
            result.append(sb);
        }

        return result.toString();
    }

    /**
     * 7.整数反转
     * @param x
     * @return
     */
    public int reverse(int x) {
        int n=0;
        while (x!=0){
            int temp = n;
            n=n*10+x%10;
            x=x/10;
            //判定是否溢出
            if (n/10 != temp){
                return 0;
            }
        }

        return n;
    }

    /**
     * 8.字符串转换整数
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        //去除空格
        s = s.trim();
        if (s.equals("")) return 0;
        char c0 = s.charAt(0);
        boolean flag = !Character.isDigit(c0) && c0!='+' && c0!='-';
        if (flag) return 0;

        //负数标识
        boolean negFlag = c0 == '-';
        long result = 0;
        int index = Character.isDigit(c0) ? 0: 1;
        while (index<s.length() && Character.isDigit(s.charAt(index))){
            result = result*10+(s.charAt(index)-'0');
            index++;
            //判定是否溢出
            if (negFlag && result-1>Integer.MAX_VALUE){
                return Integer.MIN_VALUE;
            }
            if (!negFlag && result>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
        }

        result = negFlag ? -result : result;
        return (int)result;
    }

    /**
     * 9.回文数
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString().equals(str);
    }

    /**
     * 9.回文数
     * 根据回文数特点，一半的数据反转等于另一半
     * @param x
     * @return
     */
    public boolean isPalindrome_2(int x) {
        if (x<0) return false;
        if (x!=0 && x%10==0) return false;
        if (x==0) return true;

        int temp = 0;
        while (x!=0){
            temp = temp*10 + x%10;
            //奇数位判定方式
            if (temp == x){
                return true;
            }
            //偶数位判定方式
            x=x/10;
            if (temp == x){
                return true;
            }
        }
        return false;
    }

    /**
     * 回文中心向两端扩散，符合条件回文串的长度
     * @param s
     * @param left
     * @param right
     * @return
     */
    public int calculateLength(String s , int left , int right){
        while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}
