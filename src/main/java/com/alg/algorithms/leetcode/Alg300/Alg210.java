package com.alg.algorithms.leetcode.Alg300;

import com.alg.common.ListNode;
import com.alg.design.tree.Trie;

import java.util.Stack;

public class Alg210 {
    /**
     * 203.移除链表的元素
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head==null) return head;
        ListNode virtualHead = new ListNode();
        virtualHead.next = head;
        ListNode lastNode = virtualHead;
        while (lastNode.next !=null){
            if (lastNode.next.val==val){
                lastNode.next = lastNode.next.next;
            }else {
                lastNode = lastNode.next;
            }
        }
        return virtualHead.next;
    }

    /**
     * 206.反转链表
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cursor = head;
        while (cursor !=null){
            stack.push(cursor);
            cursor = cursor.next;
        }
        int n = stack.size();
        cursor = head;
        for (int i=0;i<n/2;i++){
            ListNode last = stack.pop();
            int temp = cursor.val;
            cursor.val = last.val;
            last.val = temp;

            cursor=cursor.next;
        }
        return head;
    }

    /**
     * 206.反转链表 3.0
     * 直接反转指针：1->2->3->null;  null<-1<-2<-3
     * @param head
     * @return
     */
    public ListNode reverseList_3(ListNode head) {
        ListNode cur=head,pre=null;
        while (cur !=null){
            ListNode temp = cur.next;
            cur.next = pre;

            pre=cur;
            cur=temp;
        }

        return pre;
    }

    /**
     * 206.反转链表 2.0
     * 递归
     * @param head
     * @return
     */
    public ListNode reverseList_2(ListNode head) {
        this.head = head;
        reverse(head , 0);
        return head;
    }

    int count = 0;
    ListNode head;

    private void reverse(ListNode root , int n) {
        if (root ==null)
            return;
        count++;
        reverse(root.next , n+=1);
        if (n<=count/2){
            return;
        }

        int temp = root.val;
        root.val = head.val;
        head.val=temp;

        head = head.next;
    }

    /**
     * 206.反转链表 4.0
     * 递归，指针反转
     * @param head
     * @return
     */
    public ListNode reverseList_4(ListNode head) {
        if (null==head || null==head.next){
            return head;
        }
        ListNode newHead = reverseList_4(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }

    /**
     * 208.实现Trie(前缀树)
     */
    public void Trie(){
        Trie trie = new Trie();
        trie.insert("apple");
    }

    /**
     * 209.长度最小的子数组
     * 暴力求解
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        //设置为最大值
        int count = nums.length+1;
        int low=0;
        while (low<=nums.length-1){
            int high=low;
            int temp=0;
            while (high<nums.length){
                temp+=nums[high];
                if (temp>=target){
                    //取最小值
                    count = Math.min(count , high-low+1);
                    break;
                }
                high++;
            }
            low++;
        }
        if (count==nums.length+1) return 0;
        return count;
    }

    /**
     * 209.长度最小的子数组
     * 滑动窗口
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen_2(int target, int[] nums){
        int low=0,high=0;
        int min = Integer.MAX_VALUE;
        int sum=0;
        while (high<nums.length){
            sum+=nums[high];
            while (sum>=target){
                min = Math.min(min , high-low+1);
                sum-= nums[low];
                low++;
            }
            high++;
        }
        if (min==Integer.MAX_VALUE) return 0;
        return min;
    }
}
