package com.alg.algorithms.leetcode.alg700;

import com.alg.common.TreeNode;

public class Alg700 {

    /**
     * 700.BST中的搜索
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        search(root , val);
        return result;
    }
    TreeNode result = null;
    private void search(TreeNode root,int val){
        if (null==root || result !=null)
            return;
        if (root.val==val){
            result = root;
            return;
        }else if (val>root.val){
            search(root.right , val);
        }else {
            search(root.left,val);
        }
    }

    /**
     * 700.BST中的搜索 2.0
     * 递归
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST_2(TreeNode root, int val) {
        if (root==null) return null;

        if (val== root.val){
            return root;
        }
        return searchBST_2(val>root.val?root.right:root.left , val);
    }
}
