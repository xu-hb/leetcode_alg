package com.alg.algorithms.alg600;

import com.alg.common.TreeNode;

public class Alg550 {
    int maxDepth = 0;
    /**
     * 543.二叉树的直径
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDepth;
    }

    public int maxDepth(TreeNode root){
        if (null==root)
            return 0;
        int depthLeft = maxDepth(root.left);
        int depthRight = maxDepth(root.right);
        int sum = depthLeft+depthRight;
        maxDepth = Math.max(sum , maxDepth);
        return 1+Math.max(depthLeft,depthRight);
    }
}
