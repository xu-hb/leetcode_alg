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

    static private int index=-1;

    /**
     * 序列化-前序
     * @return
     */
    public String serializePre() {
        StringBuilder sb = new StringBuilder();
        serializePre(this , sb);
        String result = sb.toString();
        //去除第一个逗号
        if (result.startsWith(",")){
            return result.substring(1);
        }
        return result;
    }
    public void serializePre(TreeNode root , StringBuilder sb){
        if (null==root){
            sb.append(",").append("#");
            return;
        }
        sb.append(",").append(root.val);

        serializePre(root.left , sb);
        serializePre(root.right , sb);
    }

    /**
     * 反序列化--前序
     * @param data
     * @return
     */
    public static TreeNode deserializePre(String data) {
        if (null==data || data.equals(""))
            return null;
        String[] origin = data.split(",");
        return deserializePre(origin , 0);
    }
    private static TreeNode deserializePre(String[] origin, int start) {
        if (start> origin.length-1){
            return null;
        }
        index++;
        String rootVal = origin[start];
        if ("#".equals(rootVal))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(rootVal));
        root.left = deserializePre(origin , start+1);
        root.right = deserializePre(origin,index+1);
        return root;
    }
}
