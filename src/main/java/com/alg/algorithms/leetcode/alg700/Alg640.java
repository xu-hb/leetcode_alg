package com.alg.algorithms.leetcode.alg700;

import com.alg.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Alg640 {
    /**
     * 632.在二叉树中增加一行
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param root
     * @param val
     * @param depth
     * @return
     */
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        //虚拟节点
        TreeNode dummyNode = new TreeNode(-1);
        dummyNode.left=root;
        //结束节点
        TreeNode endNode = new TreeNode(-1);
        //栈
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node;
        queue.add(dummyNode);
        queue.add(endNode);

        while (! queue.isEmpty()){
            if (depth==1){
                break;
            }
            node = queue.poll();
            if (node==endNode){
                --depth;
                //未到指定深度
                queue.add(endNode);
            }else {
                if (node.left !=null) queue.add(node.left);
                if (node.right !=null) queue.add(node.right);
            }
        }

        //此时达到指定深度的父级
        while (! queue.isEmpty()){
            TreeNode curNode = queue.poll();
            if (null !=curNode && curNode!=endNode){
                //左子树
                TreeNode leftNode = new TreeNode(val);
                leftNode.left = curNode.left;
                curNode.left=leftNode;
                //右子树
                TreeNode rightNode = new TreeNode(val);
                rightNode.right = curNode.right;
                curNode.right=rightNode;
            }
        }
        return dummyNode.left;
    }

    /**
     * 632.在二叉树中增加一行 2.0
     * BFS：优化
     * @param root
     * @param val
     * @param depth
     * @return
     */
    public TreeNode addOneRow_2(TreeNode root, int val, int depth){
        if (depth==1){
            return new TreeNode(val , root , null);
        }

        List<TreeNode> list = new LinkedList<>();
        list.add(root);
        for (int i=1;i<depth-1;i++){
            List<TreeNode> sunNodes = new LinkedList<>();
            for (TreeNode node : list){
                if (node.left !=null) sunNodes.add(node.left);
                if (node.right !=null) sunNodes.add(node.right);
                list = sunNodes;
            }
        }

        for (TreeNode node : list){
            node.left = new TreeNode(val , node.left ,null);
            node.right = new TreeNode(val , null, node.right);
        }

        return root;
    }

    /**
     * 632.在二叉树中增加一行 3.0
     * DFS
     * @param root
     * @param val
     * @param depth
     * @return
     */
    public TreeNode addOneRow_3(TreeNode root, int val, int depth){
        if (depth==1){
            return new TreeNode(val , root , null);
        }
        this.val = val;
        this.depth = depth;
        dfs(root,1);
        return root;
    }
    private int val,depth;
    private void dfs(TreeNode root , int d) {
        if (root==null) return;
        if (d==depth-1){
            root.left = new TreeNode(val , root.left , null);
            root.right = new TreeNode(val , null , root.right);
        }
        dfs(root.left,d+1);
        dfs(root.right,d+1);
    }
}
