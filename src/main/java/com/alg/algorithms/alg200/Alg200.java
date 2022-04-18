package com.alg.algorithms.alg200;

import com.alg.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Alg200 {
    /**
     * 199.二叉树的右视图
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (null==root){
            return resList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (! queue.isEmpty()){
            int len = queue.size();
            int lastVal = 0;
            //遍历同一层级
            while (len>0){
                TreeNode node = queue.poll();
                lastVal = node.val;
                if (null != node.left) queue.add(node.left);
                if (null != node.right) queue.add(node.right);
                len--;
            }
            resList.add(lastVal);
        }
        return resList;
    }
}
