package com.alg.algorithms.alg900;

import com.alg.common.TreeNode;

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
}
