package com.alg.algorithms.leetcode.alg1000;

import com.alg.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Alg970 {
    /**
     * 965.单值二叉树
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param root
     * @return
     */
    public boolean isUnivalTree(TreeNode root) {
        if (root==null) return true;
        if (root.left !=null && root.left.val != root.val) return false;
        if (root.right !=null && root.right.val !=root.val) return false;
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }

    /**
     * 965.单值二叉树 2.0
     * BFS
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param root
     * @return
     */
    public boolean isUnivalTree_2(TreeNode root){
        if (root==null) return true;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (! deque.isEmpty()){
            TreeNode node = deque.poll();
            if (node.val !=root.val) return false;
            if (node.left !=null) deque.addLast(node.left);
            if (node.right !=null) deque.addLast(node.right);
        }
        return true;
    }
}
