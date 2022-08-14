package com.alg.algorithms.offer.alg50;

import com.alg.common.ListNode;

public class Alg30 {
    /**
     * 22.链表中倒数第k个节点
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head==null)
            return null;

        ListNode fast = head,slow=head;
        int i=1;
        for (;i<=k && fast !=null ;i++){
            fast = fast.next;
        }
        //链表长度小于k
        if (i<=k){
            return null;
        }

        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 24.反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
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
     * 25.合并两个排序的链表
     * 时间复杂度：O(N+M)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode();
        ListNode cursor = dummyNode;

        while (l1 !=null && l2 !=null){
            if (l1.val<=l2.val){
                cursor.next=l1;
                l1=l1.next;
            }else {
                cursor.next=l2;
                l2=l2.next;
            }
            cursor = cursor.next;
        }
        if (l1 !=null){
            cursor.next=l1;
        }
        if (l2 !=null){
            cursor.next=l2;
        }
        return dummyNode.next;
    }
}
