package com.alg.algorithms.leetcode.alg1000;

import com.alg.common.TreeNode;

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


}
