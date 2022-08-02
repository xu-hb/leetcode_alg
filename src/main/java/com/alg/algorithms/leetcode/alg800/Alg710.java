package com.alg.algorithms.leetcode.alg800;

public class Alg710 {
    /**
     * 704.二分查找
     * 时间复杂度：O(logN)
     * 空间复杂度：O(1)
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (null==nums || nums.length==0) return -1;
        int left=0;
        int right=nums.length-1;

        while (left<=right){
            int middle = (left+right)/2;
            if (nums[middle] == target){
                return middle;
            }else if (nums[middle] < target){
                left = middle+1;
            }else {
                right = middle-1;
            }
        }
        return -1;
    }

    /**
     * 707.设计链表
     */
    static class MyLinkedList {
        Node head;
        int size;
        public MyLinkedList() {
            size=0;
            head=new Node(0);
        }

        public int get(int index) {
            if (index<0 || index>=size){
                return -1;
            }
            Node cursor = head;
            for (int i=0;i<index+1;i++) cursor=cursor.next;
            return cursor.val;
        }

        public void addAtHead(int val) {

        }

        public void addAtTail(int val) {

        }

        public void addAtIndex(int index, int val) {

        }

        public void deleteAtIndex(int index) {

        }
    }

    static class Node{
        int val;
        Node next;
        public Node(int val){
            this.val=val;
        }
    }
}
