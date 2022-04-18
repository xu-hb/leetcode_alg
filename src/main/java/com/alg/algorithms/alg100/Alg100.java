package com.alg.algorithms.alg100;

import com.alg.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Alg100 {
    /**
     * 94.二叉树的中序遍历
     * 递归
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
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
        //左节点
        traversal(node.left,list);
        //中节点
        list.add(node.val);
        //右节点
        traversal(node.right , list);
    }
}
