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
}
