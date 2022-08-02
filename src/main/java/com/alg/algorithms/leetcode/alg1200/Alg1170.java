package com.alg.algorithms.leetcode.alg1200;

import com.alg.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Alg1170 {
    /**
     * 1161.最大层内元素和
     * @param root
     * @return
     */
    public int maxLevelSum(TreeNode root) {
        int max = Integer.MIN_VALUE;
        int idx = -1;
        int depth = 1;
        int sum = 0;
        TreeNode poisonNode = new TreeNode();

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        deque.add(poisonNode);

        while (! deque.isEmpty()){
            TreeNode node = deque.poll();
            if (node==poisonNode) {
                if (sum> max){
                    idx=depth;
                    max = sum;
                }
                sum=0;
                depth++;
                if (! deque.isEmpty()){
                    deque.add(poisonNode);
                }
            }else {
                sum += node.val;
                if (null != node.left) deque.add(node.left);
                if (null != node.right) deque.add(node.right);
            }
        }
        return idx;
    }
}
