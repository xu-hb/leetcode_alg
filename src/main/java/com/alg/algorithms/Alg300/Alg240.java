package com.alg.algorithms.Alg300;

import com.alg.common.TreeNode;

import java.util.Arrays;
import java.util.List;

public class Alg240 {
    /**
     * 235.二叉搜索时的最近公共祖先
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

    /**
     * 236.二叉树的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q) {
        location(root , p.val , q.val);
        return result;
    }
    TreeNode result = null;
    private boolean location(TreeNode root , int pVal , int qVal) {
        if (root==null) return false;
        boolean leftFlag = location(root.left , pVal , qVal);
        boolean rightFlag = location(root.right , pVal , qVal);
        if ((leftFlag && rightFlag)||(root.val==pVal||root.val==qVal)&&(leftFlag || rightFlag)){
            result=root;
        }
        return leftFlag || rightFlag || root.val==pVal || root.val==qVal;
    }
}
