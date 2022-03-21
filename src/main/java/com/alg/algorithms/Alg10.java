package com.alg.algorithms;

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

    public class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val){this.val = val;}
        ListNode(int val , ListNode next){this.val = val; this.next = next;}
    }
}
