package com.alg.design.tree;

import com.alg.common.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * 37.序列化二叉树
 * BFS
 */
public class Codec {
    /**
     * BFS序列化
     * @see com.alg.algorithms.leetcode.alg400.Alg300#serialize(TreeNode) DFS序列化
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        if (root==null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (! queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node!=null){
                sb.append(",").append(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }else {
                sb.append(",").append("#");
            }
        }
        return sb.substring(1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (Objects.equals(data, "")){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);
        int cur = 1;
        while (!queue.isEmpty() && cur< values.length){
            TreeNode node = queue.poll();
            //左子树
            if (values[cur].equals("#")){
                node.left=null;
            }else {
                node.left = new TreeNode(Integer.parseInt(values[cur]));
                queue.add(node.left);
            }
            cur+=1;
            //右子树
            if (values[cur].equals("#")){
                node.right=null;
            }else {
                node.right = new TreeNode(Integer.parseInt(values[cur]));
                queue.add(node.right);
            }
            cur+=1;
        }
        return root;
    }
}
