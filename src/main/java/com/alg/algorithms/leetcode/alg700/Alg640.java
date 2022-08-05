package com.alg.algorithms.leetcode.alg700;

import com.alg.common.TreeNode;

import java.util.LinkedList;
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
}
