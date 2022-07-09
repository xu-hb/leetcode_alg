package com.alg.common;

import java.util.LinkedList;
import java.util.Queue;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public String toString(){
        //层序遍历
        Queue<Node> queue = new LinkedList<>();
        queue.add(this);
        StringBuilder sb = new StringBuilder();

        while (! queue.isEmpty()){
            int len = queue.size();
            StringBuilder temp = new StringBuilder();
            while (len>0){
                Node node = queue.poll();
                temp.append(",").append(node.val);
                if (node.next !=null) temp.append(",").append(node.next.val);
                else temp.append(",").append("#");

                if (node.left !=null) queue.offer(node.left);
                if (node.right !=null) queue.offer(node.right);
                len--;
            }
            sb.append("[").append(temp).append("]");
        }
        return sb.toString();
    }
}
