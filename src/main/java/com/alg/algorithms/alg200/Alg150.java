package com.alg.algorithms.alg200;

import com.alg.common.TreeNode;

import java.util.*;

public class Alg150 {
    /**
     * 144.二叉树的前序遍历
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if(Objects.isNull(root)){
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        //递归遍历
        traversal(root , list);
        return list;
    }

    //递归遍历
    public void traversal(TreeNode node, List<Integer> list) {
        if (node==null) return;
        //中节点
        list.add(node.val);
        //左节点
        traversal(node.left,list);
        //右节点
        traversal(node.right , list);
    }

}
