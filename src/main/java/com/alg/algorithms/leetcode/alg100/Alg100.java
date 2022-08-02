package com.alg.algorithms.leetcode.alg100;

import com.alg.common.ListNode;
import com.alg.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Alg100 {
    List<String> ipStrList = new ArrayList<>();
    List<String> tempList = new ArrayList<>();
    int len;
    int minCursor;

    /**
     * 92.反转链表 II
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next==null || left==right)
            return head;

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode preLeft=dummy,leftNode=dummy.next;
        //定位到left
        for (int i=2;i<=left;i++){
            preLeft = leftNode;
            leftNode = leftNode.next;
        }
        //left~right开始反转
        ListNode cursor = leftNode.next,preCursor = leftNode;
        for (int i=left+1;i<=right;i++){
            ListNode temp = cursor.next;
            cursor.next = preCursor;
            preCursor=cursor;
            cursor = temp;
        }
        //拼接后续
        preLeft.next.next=cursor;
        preLeft.next=preCursor;
        return dummy.next;
    }

    /**
     * 92.反转链表 II
     * advance:一次遍历
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween_2(ListNode head, int left, int right){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre=dummy;
        //定位到left
        for (int i=0;i<left-1;i++){
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode next;
        //头插法
        for (int i=0;i<right-left;i++){
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }

    /**
     * 93.复原IP地址
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        len=s.length();
        minCursor = len/4-1;
        dfsPartition(s,0,1);
        return ipStrList;
    }

    private void dfsPartition(String s , int size,int depth){
        if (size==len){
            if (depth==5){
                ipStrList.add(String.join(".",tempList));
                return;
            }else {
                return;
            }
        }
        for (int i=0;i<Math.min(s.length(),3);i++){
            String str = s.substring(0,i+1);
            if (validateIp(str)&&depth<=4){
                tempList.add(str);
                String rightStr = s.substring(i+1);
                dfsPartition(rightStr,size+str.length(),depth+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    /**
     * 校验是否为合法ip
     * @param str
     * @return
     */
    private boolean validateIp(String str) {
        boolean flag = Long.parseLong(str)<=255;
        return flag && ((str.length()>1 && !str.startsWith("0"))||str.length()==1);
    }

    /**
     * 94.二叉树的中序遍历
     * 递归
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if(Objects.isNull(root)){
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        //递归遍历
        traversal(root , list);
        return list;
    }

    //递归遍历
    public void traversal(TreeNode node, List<Integer> list) {
        if (node==null) return;
        //左节点
        traversal(node.left,list);
        //中节点
        list.add(node.val);
        //右节点
        traversal(node.right , list);
    }

    /**
     * 96.不同的二叉搜索树
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    /**
     * 98.验证BST
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        validBST(root);
        return result;
    }

    boolean result = true;
    long preVal= Long.MIN_VALUE;    //前一个节点的值

    private void validBST(TreeNode root){
        if (root==null || !result)
            return;
        validBST(root.left);
        //中序遍历，当期值应该>preVal
        if (root.val<=preVal){
            result=false;
            return;
        }
        //赋予当期节点值
        preVal= root.val;
        validBST(root.right);
    }
}
