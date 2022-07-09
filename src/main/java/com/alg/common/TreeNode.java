package com.alg.common;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public String toString(){
        //层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);
        StringBuilder sb = new StringBuilder();

        while (! queue.isEmpty()){
            int len = queue.size();
            StringBuilder temp = new StringBuilder();
            while (len>0){
                TreeNode node = queue.poll();
                temp.append(",").append(node.val);

                if (node.left !=null) queue.offer(node.left);
                if (node.right !=null) queue.offer(node.right);
                len--;
            }
            sb.append("[").append(temp).append("]");
        }
        return sb.toString();
    }
}
