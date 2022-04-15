package com.alg.algorithms.alg200;

import com.alg.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
}
