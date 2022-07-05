package com.alg.algorithms.alg900;

import com.alg.common.ListNode;

public class Alg880 {
    /**
     * 876.链表中间的节点
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        if (null == head)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast !=null && fast.next !=null){
            //慢走一步，快走两步
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
