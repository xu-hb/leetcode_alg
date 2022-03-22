package com.alg.algorithms;

import com.alg.common.ListNode;

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
}
