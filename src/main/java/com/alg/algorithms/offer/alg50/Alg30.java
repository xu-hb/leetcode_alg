package com.alg.algorithms.offer.alg50;

import com.alg.common.ListNode;
import com.alg.common.TreeNode;
import com.alg.design.stack.MinStack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    /**
     * 24.反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur=head,pre=null;
        while (cur !=null){
            ListNode temp = cur.next;
            cur.next = pre;

            pre=cur;
            cur=temp;
        }

        return pre;
    }

    /**
     * 25.合并两个排序的链表
     * 时间复杂度：O(N+M)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode();
        ListNode cursor = dummyNode;

        while (l1 !=null && l2 !=null){
            if (l1.val<=l2.val){
                cursor.next=l1;
                l1=l1.next;
            }else {
                cursor.next=l2;
                l2=l2.next;
            }
            cursor = cursor.next;
        }
        if (l1 !=null){
            cursor.next=l1;
        }
        if (l2 !=null){
            cursor.next=l2;
        }
        return dummyNode.next;
    }

    /**
     * 25.合并两个排序的链表 2.0
     * 递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists_2(ListNode l1, ListNode l2) {
        if (l1==null)
            return l2;
        if (l2==null)
            return l1;

        if (l1.val<=l2.val){
            l1.next = mergeTwoLists_2(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists_2(l1,l2.next);
            return l2;
        }
    }

    /**
     * 26.树的子结构
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B==null || A==null)
            return false;
        //先序
        boolean res = judgeEqu(A,B);
        if (! res){
            res = isSubStructure(A.left,B);
        }
        if (! res){
            res = isSubStructure(A.right,B);
        }
        return res;
    }

    private boolean judgeEqu(TreeNode A, TreeNode B){
        if (B==null)
            return true;
        if (A==null)
            return false;
        if (A.val==B.val) {
            return judgeEqu(A.left, B.left) && judgeEqu(A.right, B.right);
        }
        return false;
    }

    /**
     * 26.树的结构 2.0
     * 代码简化
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure_2(TreeNode A, TreeNode B){
        return (A!=null && B!=null) && (recur(A,B) || isSubStructure_2(A.left,B) || isSubStructure_2(A.right,B));
    }

    private boolean recur(TreeNode A, TreeNode B) {
        if (B==null) return true;
        if (A==null || A.val!=B.val) return false;
        return recur(A.left,B.left) && recur(A.right,B.right);
    }

    /**
     * 27.二叉树的镜像
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root==null)
            return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;
    }

    /**
     * 27.二叉树的镜像 2.0
     * 迭代
     * @param root
     * @return
     */
    public TreeNode mirrorTree_2(TreeNode root){
        if (root==null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (! queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left !=null) queue.add(node.left);
            if (node.right !=null) queue.add(node.right);
        }
        return root;
    }

    /**
     * 28.对称的二叉树
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root , root);
    }

    private boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1==null && root2==null)
            return true;
        if (root1==null || root2==null)
            return false;
        return root1.val == root2.val && isSymmetric(root1.left,root2.right) && isSymmetric(root1.right,root2.left);
    }

    /**
     * 28.对称的二叉树 2.0
     * 迭代
     * @param root
     * @return
     */
    public boolean isSymmetric_2(TreeNode root) {
        if (root==null)
            return true;
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode r1=root,r2=root;
        deque.push(r1);
        deque.push(r2);

        while (! deque.isEmpty()){
            r2 = deque.poll();
            r1 = deque.poll();
            if (r1==null && r2==null)
                continue;
            if (r1==null || r2==null || r2.val!=r1.val)
                return false;
            deque.push(r1.left);
            deque.push(r2.right);

            deque.push(r1.right);
            deque.push(r2.left);
        }
        return true;
    }

    /**
     * 30.包含min函数的栈
     * @see MinStack
     * @return
     */
    public MinStack MinStack(){
        MinStack stack = new MinStack();
        stack.push(-1);
        return stack;
    }
}
