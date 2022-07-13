package com.alg.algorithms.Alg300;

import com.alg.common.TreeNode;



public class Alg230 {
    /**
     * 226.翻转二叉树
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return root;
        }
        turn(root);
        return root;
    }

    private void turn(TreeNode node){
        if (node==null){
            return;
        }
        TreeNode nLeft = node.left;
        TreeNode nRight = node.right;
        node.left = nRight;
        node.right = nLeft;
        turn(node.left);
        turn(node.right);
    }

    /**
     * 230.二叉树中的第k小的元素
     * 中序遍历
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        //中序遍历
        this.k = k;
        midTraverse(root);
        return result;
    }

    int count=0;
    int k;
    int result=0;
    private void midTraverse(TreeNode root) {
        if (root==null || count>k)
            return;
        midTraverse(root.left);
        count++;
        if (count==k){
            result = root.val;
        }
        midTraverse(root.right);
    }

}
