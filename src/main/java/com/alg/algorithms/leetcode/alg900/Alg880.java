package com.alg.algorithms.leetcode.alg900;

import com.alg.common.ListNode;

import java.util.Arrays;

public class Alg880 {

    /**
     * 875.爱吃香蕉的可可
     * @param piles
     * @param h
     * @return
     */
    public int minEatingSpeed(int[] piles, int h) {
        //吃香蕉速度下限
        int low = 1;
        //吃香蕉速度上限
        int high = Arrays.stream(piles).max().getAsInt();

        while (low<=high){
            long needHour = 0;
            int middle = low+(high-low)/2;
            for (int p : piles){
                //向上取整
                needHour += (p + middle - 1) / middle;
            }
            if (needHour>h){
                low=middle+1;
            }else {
                high=middle-1;
            }
        }
        return low;
    }

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
