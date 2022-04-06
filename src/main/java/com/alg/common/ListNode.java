package com.alg.common;

/**
 *
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val){this.val = val;}
    public ListNode(int val , ListNode next){this.val = val; this.next = next;}

    public static ListNode init(int[] arr){
        if (arr.length<1) return null;
        ListNode virtualNode = new ListNode();
        ListNode head = new ListNode(arr[0]);
        virtualNode.next=head;
        for (int i=1;i<arr.length;i++){
            ListNode node = new ListNode(arr[i]);
            head.next=node;
            head=node;
        }
        return virtualNode.next;
    }
}
