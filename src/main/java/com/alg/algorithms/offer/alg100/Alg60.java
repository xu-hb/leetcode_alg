package com.alg.algorithms.offer.alg100;

import com.alg.common.ListNode;

public class Alg60 {
    /**
     * 52.两个链表的第一个公共节点
     * 时间复杂度：O(Max(M,N))
     * 空间复杂度：O(1)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null || headB==null) return null;
        int lenA=0,lenB=0;
        ListNode curA = headA,curB=headB;
        while (curA !=null){
            lenA++;
            curA=curA.next;
        }
        while (curB !=null){
            lenB++;
            curB=curB.next;
        }
        curA = headA;
        curB=headB;
        while (lenA>lenB){
            curA = curA.next;
            lenA--;
        }
        while (lenB>lenA){
            curB = curB.next;
            lenB--;
        }

        while (lenA>0){
            if (curA==curB){
                return curA;
            }
            curA=curA.next;
            curB=curB.next;
            lenA--;
        }
        return null;
    }

    /**
     * 52.两个链表的第一个公共节点 2.0
     * 代码简化
     * 时间复杂度：O(n+m)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode_2(ListNode headA, ListNode headB){
        if (null==headA || null==headB) return null;

        ListNode curA = headA,curB=headB;
        while (curA !=curB){
            curA = curA==null ? headB : curA.next;
            curB = curB==null ? headA : curB.next;
        }
        return curA;
    }
}
