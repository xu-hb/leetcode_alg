package com.alg.algorithms.alg1100;

import com.alg.common.TreeNode;

public class Alg1040 {
    /**
     * 1038.从二叉树到更大和树
     * @param root
     * @return
     */
    public TreeNode bstToGst(TreeNode root) {
        if (null==root)
            return root;
        //中序反转遍历
        traversalMidRev(root);
        return root;
    }
    int sum = 0;
    private void traversalMidRev(TreeNode root) {
        if (root==null)
            return;
        //中序遍历反转，先遍历右侧
        traversalMidRev(root.right);
        sum += root.val;
        root.val = sum;
        traversalMidRev(root.left);
    }
}
