package com.alg.algorithms.leetcode.alg900;

import com.alg.common.ListNode;
import com.alg.common.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class Alg820 {
    /**
     * 814.二叉树剪枝
     * @param root
     * @return
     */
    public TreeNode pruneTree(TreeNode root) {
        boolean flag = dfs(root);
        if (flag) return null;  //减去根节点
        return root;
    }

    private boolean dfs(TreeNode root){
        if (root==null) return true;
        boolean leftVal = dfs(root.left);
        boolean rightVal = dfs(root.right);
        if (leftVal) root.left=null;
        if (rightVal) root.right=null;
        return leftVal && rightVal && root.val==0;
    }

    /**
     * 814.二叉树剪枝 2.0
     * @param root
     * @return
     */
    public TreeNode pruneTree_2(TreeNode root){
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }

    /**
     * 817.链表组件
     * 时间复杂度：O(M+N)
     * 空间复杂度：O(M)
     * @param head
     * @param nums
     * @return
     */
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int n : nums){
            set.add(n);
        }

        int cnt=0;
        boolean flag = false;
        ListNode cur = head;
        while (cur !=null){
            if (set.contains(cur.val)){
                if (!flag){
                    cnt++;
                    flag=true;
                }
            }else {
                flag=false;
            }
            cur = cur.next;
        }
        return cnt;
    }
}
