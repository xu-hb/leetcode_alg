package com.alg.design.list;

/**
 * offer 36.二叉搜索树转双向链表
 */
public class MyList {
    public Node treeToDoublyList(Node root) {
        if (root==null)
            return null;
        //获取最右节点
        Node cur = root;
        while (cur.right != null){
            cur=cur.right;
        }
        tail=cur;
        //递归：树转链表
        dfs(root);
        //头、尾节点指针连接
        head.left=tail;
        tail.right=head;

        return head;
    }
    Node head;
    Node tail;
    private Node dfs(Node root){
        if (root==null)
            return null;
        Node prev = dfs(root.left);
        if (prev !=null){
            prev.right=root;
            root.left=prev;
        }
        //最左端节点
        head= head==null ? prev==null?root:prev : head;

        Node next = dfs(root.right);
        if (next!=null){
            next.left=root;
            root.right=next;
        }
        return next==null?root:next;
    }


    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}


