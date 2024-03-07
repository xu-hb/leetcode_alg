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
        if(n==1) return s;
        int maxLen = 0;
        int l=0,r=0;
        //dp:i,j：s.charAt(i)~s.charAt(j)是否是回文串
        //dp[i][j] = (j-i+1==1) || (dp[i+1][j-1] && s.charAt(i)==s.charAt(j))
        boolean[][] dp = new boolean[n][n];

        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s.charAt(i)==s.charAt(j) && (j-i+1<=2 || dp[i+1][j-1] )){
                    dp[i][j]=true;
                    if(j-i+1>maxLen){
                        maxLen=j-i+1;
                        l=i;
                        r=j;
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

    /**
     * 49.字母异位词分组
     * 时间复杂度：O(n*klogk)
     * 空间复杂度：O(n*k)
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortedStr = new String(arr);
            List<String> valueList = map.getOrDefault(sortedStr,new ArrayList<String>());
            valueList.add(str);

            map.put(sortedStr,valueList);
        }

        return new ArrayList<>(map.values());
    }

    /**
     * 49.字母异位词分组 2.0
     * 时间复杂度：O(n*(k+26))
     * 空间复杂度：O(n)
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for (String str : strs){
            int[] arr = new int[26];
            char[] splitArr = str.toCharArray();
            for (char c : splitArr){
                arr[c-'a']+=1;
            }

            StringBuilder sb = new StringBuilder();
            for (int i=0;i<26;i++){
                if (arr[i]!=0){
                    sb.append('a'+i);
                    sb.append(arr[i]);
                }
            }
            List<String> list = map.getOrDefault(sb.toString(),new ArrayList<>());
            list.add(str);
            map.put(sb.toString(),list);
        }

        return new ArrayList<>(map.values());
    }

    /**
     * 53.最大子数组和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = 0;
        for (int i=0;i<nums.length;i++){
            int sum = 0;
            for (int j=i;j<nums.length;j++){
                sum += nums[j];
                max = Math.max(max,sum);
            }
        }
        return max;
    }

    /**
     * 53.最大子数组和（good）
     * dp
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)可优化到O(1)
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        //dp[i]： 以nums[i]作为最后节点的子数组的最大数组和
        //dp[i]=dp[i-1]+nums[i];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i=1;i<nums.length;i++){
            if (dp[i-1]>=0){
                dp[i] = dp[i-1] + nums[i];
            }else {
                dp[i] = nums[i];
            }
            max = Math.max(max , dp[i]);
        }
        return max;
    }

    /**
     * 128.最长连续序列
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for(int n : nums){
            set.add(n);
        }

        int max = 0;

        for(int n : nums){
            if(set.contains(n-1))
                continue;

            int currentLength=0;
            int tempN = n;
            while(set.contains(tempN)){
                tempN++;
                currentLength++;
            }
            max = Math.max(max,currentLength);
        }
        return max;
    }

    /**
     * 283.移动零
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int fast=0,slow=0;
        while (fast<nums.length){
            if (nums[fast] !=0){
                int temp = nums[slow];
                nums[slow]=nums[fast];
                nums[fast]=temp;
                slow++;
            }
            fast++;
        }
    }

    /**
     * 560.和为k的子数组（good）
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int result=0,sum=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);   //sum-k=0,+1
        for (int i=0;i<nums.length;i++){
            sum += nums[i];

            result+=map.getOrDefault(sum-k,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return result;
    }
}
