package com.alg.algorithms;

import com.alg.common.ListNode;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 算法21-30
 */
public class Alg30 {
    /**
     * 21.合并两个有序链表
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(1)
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode cursor = result;
        while (list1 !=null && list2!=null){
            ListNode node = null;
            //比较，升序排列
            if (list1.val <= list2.val){
                node = new ListNode(list1.val);
                list1 = list1.next;
            }else {
                node = new ListNode(list2.val);
                list2 = list2.next;
            }
            cursor.next = node;
            cursor = node;
        }

        //处理剩余链表
        ListNode listNode = null;
        if (list1 !=null) listNode=list1;
        if (list2 !=null) listNode=list2;

        while (listNode !=null){
            ListNode node = new ListNode(listNode.val);
            cursor.next = node;
            cursor = node;
            listNode = listNode.next;
        }
        return result.next;
    }

    /**
     * 24.两两交换链表中的节点
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        //增加个虚拟头节点
        ListNode virtualHead = new ListNode();
        virtualHead.next= head;

        if (head==null || head.next==null){
            return head;
        }

        ListNode left=virtualHead;
        ListNode right=left.next.next;

        while (right!=null){
            ListNode middle = left.next;
            //两节点交换
            middle.next = right.next;
            right.next = middle;
            left.next = right;
            //指针后移2个节点(交换后的middle节点实际是right位置了)
            left = middle;
            if (middle.next==null || middle.next.next==null){
                break;
            }else {
                right = middle.next.next;
            }
        }

        return virtualHead.next;
    }

    /**
     * 24.两两交换链表中的节点
     * 大致逻辑一致，代码更加优美
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param head
     * @return
     */
    public ListNode swapPairs_2(ListNode head) {
        //增加个虚拟头节点
        ListNode virtualHead = new ListNode();
        virtualHead.next= head;

        ListNode left = virtualHead;
        while (left.next !=null && left.next.next !=null){
            ListNode middle = left.next;
            ListNode right = left.next.next;
            middle.next = right.next;
            right.next = middle;
            left.next = right;

            left = middle;
        }

        return virtualHead.next;
    }

    /**
     * 26.删除有序数组中的重复项
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int index = 0;
        //找到第一个重复值
        for (int i=1; i<nums.length;i++){
            if (nums[i]==nums[i-1]){
                index=i;
                break;
            }
        }
        //没有重复值，直接返回
        if (index==0) return nums.length;

        //继续遍历剩余，移动不重复值
        for (int j=index+1;j<nums.length;j++){
            if (nums[j]!=nums[j-1]){
                nums[index]=nums[j];
                ++index;
            }
        }
        return index;
    }
    /**
     * 26.删除有序数组中的重复项
     * 代码简化
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int removeDuplicates_2(int[] nums) {
        int fast =1,slow = 1;
        while (fast<nums.length){
            if (nums[fast-1]!=nums[fast]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    /**
     * 27.移除元素
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int fast=0,slow=0;
        while (fast<nums.length){
            if(nums[fast]!=val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));
        return slow;
    }

    /**
     * 28.实现strStr()
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(1)
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) return 0;
        if (needle.length()>haystack.length()) return -1;

        int m= haystack.length();
        int n = needle.length();
        for (int i=0; i+n<=m;i++){
            boolean flag = true;
            for (int k=0;k<n;k++){
                if (haystack.charAt(i+k) !=needle.charAt(k)){
                    flag = false;
                    break;
                }
            }
            if (flag) return i;
        }
        return -1;
    }

    /**
     * 28.实现strStr()
     * KMP算法 todo
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr_2(String haystack, String needle) {
        return -1;
    }
}
