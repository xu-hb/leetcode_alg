package com.alg.algorithms.leetcode.Alg300;

import com.alg.common.TreeNode;



public class Alg230 {

    /**
     * 222.完全二叉树的节点个数
     * 时间复杂度:O(N)
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        calculate(root);
        return count;
    }

    int count2=0;
    private void calculate(TreeNode root) {
        if (root==null) return;
        count2++;
        calculate(root.left);
        calculate(root.right);
    }

    /**
     * 222.完全二叉树的节点个数 2.0
     * 时间复杂度:O(log^2 N)
     * @param root
     * @return
     */
    public int countNodes_2(TreeNode root) {
        TreeNode l = root , r = root;
        int lCount = 0,rCount=0;
        while (l!=null){
            l=l.left;
            lCount++;
        }
        while (r!=null){
            r=r.right;
            rCount++;
        }

        if (lCount==rCount){
            return (int)Math.pow(2,lCount)-1;
        }
        return 1+countNodes_2(root.left)+countNodes_2(root.right);
    }

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
            return;
        }
        midTraverse(root.right);
    }

}
