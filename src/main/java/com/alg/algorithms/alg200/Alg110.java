package com.alg.algorithms.alg200;

import com.alg.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Alg110 {
    /**
     * 102.二叉树的层序遍历
     * 递归
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        int deep=0;
        recursion(resList , root , deep);
        return resList;
    }

    /**
     * 递归
     * @param resList
     * @param node
     * @param deep
     */
    private void recursion(List<List<Integer>> resList, TreeNode node, int deep) {
        if (null == node){
            return;
        }
        ++deep;
        if (resList.size()<deep){
            resList.add(new ArrayList<>());
        }
        resList.get(deep-1).add(node.val);
        recursion(resList , node.left , deep);
        recursion(resList , node.right , deep);
    }

    /**
     * 102.二叉树的层序遍历 2
     * 队列
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_2(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (null==root){
            return resList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (! queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            resList.add(list);
            int len = queue.size();
            //遍历同一层级
            while (len>0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (null != node.left) queue.add(node.left);
                if (null != node.right) queue.add(node.right);
                len--;
            }
        }
        return resList;
    }

    /**
     * 104.二叉树的最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root==null)
            return 0;
        //后序遍历
        int depthLeft = maxDepth(root.left);
        int depthRight = maxDepth(root.right);
        return Math.max(depthLeft , depthRight)+1;
    }


    /**
     * 107.二叉树的层序遍历two
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (null==root){
            return resList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (! queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            //后来居上
            resList.add(0,list);
            int len = queue.size();
            //遍历同一层级
            while (len>0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (null != node.left) queue.add(node.left);
                if (null != node.right) queue.add(node.right);
                len--;
            }
        }
        return resList;
    }
}