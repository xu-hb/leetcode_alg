package com.alg.algorithms;

import com.alg.common.ListNode;

/**
 * 算法21-30
 */
public class Alg30 {
    /**
     * 31.合并两个有序链表
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
}
