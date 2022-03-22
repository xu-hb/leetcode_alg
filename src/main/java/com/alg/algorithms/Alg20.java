package com.alg.algorithms;

import com.alg.algorithms.common.ListNode;

import java.util.*;

/**
 * 算法11-20
 */
public class Alg20 {
    /**
     * 11.盛最多水的容器
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i=0;i<height.length;i++){
            for (int j=i+1;j<height.length;j++){
                int temp = Math.min(height[i] , height[j]) * (j-i);
                maxArea = Math.max(temp , maxArea);
            }
        }
        return maxArea;
    }

    /**
     * 11.盛最多水的容器
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     * @param height
     * @return
     */
    public int maxArea_2(int[] height) {
        int maxArea = 0;
        int head=0, tail=height.length-1;
        while (tail>head){
            //计算当前面积
            int temp = Math.min(height[head] , height[tail]) * (tail-head);
            maxArea = Math.max(temp , maxArea);
            //值小的指针移动
            if (height[head] > height[tail]){
                tail--;
            }else {
                head++;
            }
        }
        return maxArea;
    }

    /**
     * 12.整数转罗马数字
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] values = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i=0; i<values.length; i++){
            while (num>=values[i]){
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

    /**
     * 13.罗马数字转整数
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        Map<Character , Integer> map = new HashMap<>();
        map.put('I' , 1);
        map.put('V' , 5);
        map.put('X' , 10);
        map.put('L' , 50);
        map.put('C' , 100);
        map.put('D' , 500);
        map.put('M' , 1000);

        int result = 0;
        for (int i=0;i<s.length()-1;i++){
            int v1 = map.get(s.charAt(i));
            int v2 = map.get(s.charAt(i+1));
            if (v1<v2){
                result -=v1;
            }else {
                result +=v1;
            }
        }
        result += map.get(s.charAt(s.length()-1));
        return result;
    }

    /**
     * 14.最长公共前缀
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        String first = strs[0];

        for (int i=0; i<first.length();i++){
            for (int j=1;j<strs.length;j++){
                if (i>=strs[j].length() || first.charAt(i)!=strs[j].charAt(i)){
                    return first.substring(0,i);
                }
            }
        }
        return first;
    }

    /**
     * 15.三数之和
     * 时间复杂度：O(N^3)
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        //避免得到重复结果，先排序
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i=0;i<nums.length;i++){
            if (i>0 && nums[i-1] == nums[i]){
                continue;
            }
            for (int j=i+1; j< nums.length; j++){
                if (j>i+1 && nums[j-1] == nums[j]){
                    continue;
                }
                for (int k=j+1;k< nums.length;k++){
                    if (k>j+1 && nums[k-1]==nums[k]){
                        //相同值忽略
                        continue;
                    }
                    if (nums[i]+nums[j]+nums[k]==0){
                        result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    }
                }
            }
        }

        return result;
    }

    /**
     * 15.三数之和
     * 时间复杂度：O(N^2)
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum_2(int[] nums) {
        //避免得到重复结果，先排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i=0;i<nums.length;i++){
            if (i>0 && nums[i-1]==nums[i]){
                continue;
            }
            int left=i+1;
            int right=nums.length-1;

            //双指针移动
            while (left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum ==0){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //指向下一个值
                    left++;
                    //忽略重复值
                    while (left<right && nums[left-1]==nums[left]) left++;
                }else if (sum<0){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return result;
    }

    /**
     * 16.最接近的三数之和
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result=nums[0]+nums[1]+nums[2];

        for (int i=0;i<nums.length;i++){
            int left=i+1;
            int right=nums.length-1;

            //双指针移动
            while (left<right){
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(target-result) - Math.abs(target-sum);
                if (diff>0){
                    result = sum;
                }else if (target>sum){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return result;
    }

    /**
     * 16.最接近的三数之和
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest_2(int[] nums, int target) {
        Arrays.sort(nums);
        int result=10000;   //题目限定-1000 <= nums[i] <= 1000

        for (int i=0;i<nums.length;i++){
            if (i>0 && nums[i-1]==nums[i]){
                continue;
            }

            int left=i+1;
            int right=nums.length-1;

            //双指针移动
            while (left<right){
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(target-sum) - Math.abs(target-result);
                if (diff<=0){
                    result = sum;
                }

                if (target==sum){
                    return sum;
                }else if (target>sum){
                    left++;
                    while (left<right && nums[left-1]==nums[left]) left++;
                }else {
                    right--;
                    while (left<right && nums[right+1]==nums[right]) right--;
                }
            }
        }
        return result;
    }

    /**
     * 17.电话号码的字母组合
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if (null == digits || "".equals(digits)){
            return new ArrayList<>();
        }
        Map<Character , String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        //回溯
        combine(map , sb , digits , 0 , result);
        return result;
    }

    /**
     * 19.删除链表的倒数第N个结点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n<0) return head;

        //节点的数量
        int nodeCount = 0;
        //游标
        ListNode cursor = head;
        //当前游标下倒数第N+1个节点
        ListNode preNode = null;
        while (Objects.nonNull(cursor)){
            ++nodeCount;
            //倒数第N+1个节点
            if (nodeCount==n+1){
                preNode=head;
            }else if (nodeCount>n+1){
                preNode = preNode.next;
            }
            cursor = cursor.next;
        }
        //由于preNode记录倒数N+1个节点，当节点数=N个节点的情况需要处理
        if (nodeCount==n){
            return head.next;
        }
        //删除倒数N个节点
        preNode.next = preNode.next.next;
        return head;
    }

    /**
     * 回溯所有组合
     * @param map
     * @param sb
     * @param digits
     * @param index
     * @param result
     */
    private void combine(Map<Character, String> map, StringBuilder sb, String digits, int index, List<String> result) {
        //遍历到最深一层为止
        if (index==digits.length()){
            result.add(sb.toString());
            return;
        }

        String str = map.get(digits.charAt(index));
        //遍历同一层的所有元素
        for (int i=0;i<str.length();i++){
            sb.append(str.charAt(i));
            //递归
            combine(map , sb , digits , index+1 , result);
            //处理完同一层的上一个元素后，处理下一个元素时，需回溯裁剪掉当前值
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
