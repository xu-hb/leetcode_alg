package com.alg.algorithms.offer.alg100;

import com.alg.common.ListNode;

public class Alg60 {
    /**
     * 52.两个链表的第一个公共节点
     * @param headA
     * @param headB
     * @return
     */
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
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
}
