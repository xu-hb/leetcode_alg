package com.alg.algorithms.offer.alg100;

import com.alg.common.TreeNode;

public class Alg70 {
    /**
     * 68-I.二叉搜索树的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        min = Math.min(pVal,qVal);
        max = Math.max(pVal,qVal);
        return search(root);
    }
    int min = 0;
    int max = 0;
    private TreeNode search(TreeNode root){
        while (root !=null){
            if (root.val>=min && root.val<=max){
                return root;
            }else if (max<= root.val){
                return search(root.left);
            }else if (min>= root.val){
                return search(root.right);
            }
        }
        return null;
    }
}
