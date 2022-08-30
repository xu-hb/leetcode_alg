package com.alg.algorithms.leetcode.alg1000;

import com.alg.common.TreeNode;

public class Alg1000 {
    /**
     * 998.最大二叉树II
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root==null) return null;
        //虚拟节点
        int dummyVal = Math.max(root.val, val)+1;
        TreeNode dummyNode = new TreeNode(dummyVal);
        dummyNode.right=root;
        dfs(dummyNode,val);
        return dummyNode.right;
    }
    boolean insertFlag=false;
    private void dfs(TreeNode root,int val){
        if (root==null || root.val<val) return;
        //新增的val位于数组最后一个，所以位于右子树上
        dfs(root.right,val);
        //节点新增
        if (! insertFlag){
            TreeNode node = new TreeNode(val);
            node.left = root.right;
            root.right=node;
            insertFlag=true;
        }
    }

    /**
     * 998.最大二叉树II 2.0
     * BFS
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoMaxTree_2(TreeNode root, int val){
        if (root==null) return null;
        //虚拟节点
        int dummyVal = Math.max(root.val, val)+1;
        TreeNode dummyNode = new TreeNode(dummyVal);
        dummyNode.right=root;

        TreeNode cur = dummyNode;
        while (cur!=null){
            //最大树
            if (cur.right ==null || cur.right.val<val){
                TreeNode node = new TreeNode(val);
                node.left = cur.right;
                cur.right=node;
                break;
            }
            //只需遍历右子树
            cur = cur.right;
        }
        return dummyNode.right;
    }
}
