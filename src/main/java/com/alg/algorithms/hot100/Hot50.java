package com.alg.algorithms.hot100;

import com.alg.common.ListNode;

import java.util.*;

public class Hot50 {
    /**
     * 1.两数之和
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        for (int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(target-nums[i]) && i != map.get(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
        }
        return null;
    }

    /**
     * 2.两数相加
     * 时间复杂度：O(Max(l1.length,l2.length))
     * 空间复杂度：O(1)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        int highIndex = 0;  //进位
        while (l1 !=null || l2!=null){
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum = n1 + n2 + highIndex;

            highIndex = sum / 10;
            cur.next = new ListNode(sum % 10);;
            cur=cur.next;

            if (l1 !=null) l1=l1.next;
            if (l2 !=null) l2=l2.next;
        }

        if(highIndex !=0){
            cur.next = new ListNode(highIndex);;
        }
        return dummyHead.next;
    }

    /**
     * 3.无重复字符的最大子串
     * 滑动窗口
     * 时间复杂度：O(N)
     * 空间复杂度：O(C)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int[] window = new int[128];
        Arrays.fill(window,-1);
        int max = 0;
        int low=0,high=0;
        while(high<s.length()){
            char c = s.charAt(high);
            if(window[c] ==-1){
                window[c]=high;
            }else{
                //出现重复,重置重复子窗口
                for(int i=low;i<window[c];i++){
                    window[s.charAt(i)]=-1;
                }
                low=window[c]+1;
                window[c]=high;
            }
            max = Math.max(max, high-low+1);
            high++;
        }
        return max;
    }

    /**
     * 5.最长回文子串
     * 中心扩散
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        int l=0,r=0;
        for (int i=0;i<n;i++){
            int len1 = spread(s,i,i+1);
            int len2 = spread(s,i,i);
            int len = Math.max(len1,len2);
            if (len>r-l+1){
                if (len1>=len2){
                    l=1+i-len/2;
                    r=i+len/2;
                }else {
                    l=i-len/2;
                    r=i+len/2;
                }
            }
        }
        return s.substring(l,r+1);
    }

    /**
     * 5.最长回文子串 2.0
     * DP
     * @param s
     * @return
     */
    public String longestPalindrome_2(String s){
        int n = s.length();
        if (n==1) return s;
        //dp:s从i~j的子串是否为回文串
        boolean dp[][] = new boolean[n][n];
        int l=0,r=0;

        for (int i=0;i<n;i++){
            for (int j=0;j<i;j++){
                if (s.charAt(j)==s.charAt(i) && (dp[j+1][i-1] || i-j+1<=3)){
                    dp[j][i]=true;
                    if (i-j>r-l){
                        l=j;
                        r=i;
                    }
                }
            }
        }
        return s.substring(l,r+1);
    }

    private int spread(String s, int l , int r){
        while (l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return (r-1)-(l+1)+1;
    }

    /**
     * 11.盛最多水的容器
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int l=0,r=height.length-1;
        int max = 0;
        while(l<r){
            int area = (r-l)*Math.min(height[l],height[r]);
            max = Math.max(max,area);
            if(height[l]<height[r]){
                int curL=l+1;
                while (height[curL]<=height[l] && curL<r) curL++;
                l=curL;
            }else{
                int curR=r-1;
                while (height[curR]<=height[r] && curR>l) curR--;
                r=curR;
            }
        }
        return max;
    }

    /**
     * 15.三数之和
     * 双指针
     * 注意和1.两数之和的区别
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(logN)
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0;i<n;i++){
            //排序后，避免重复值
            if (i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            int l=i+1,r=n-1;
            while (l<r){
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    //避免重复值
                    while (l<r && nums[l]==nums[l-1]) l++;
                }else if (sum>0){
                    r--;
                }else {
                    l++;
                }
            }
        }
        return res;
    }
}
