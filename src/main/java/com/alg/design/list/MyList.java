package com.alg.design.list;

/**
 * offer 36.二叉搜索树转双向链表
 */
public class MyList {
    public Node treeToDoublyList(Node root) {
        if (root==null)
            return null;
        //递归：树转链表
        dfs(root);
        //头、尾节点指针连接(中序遍历完,prev就是最后一个节点)
        head.left=prev;
        prev.right=head;
        return head;
    }
    Node head;
    Node prev;
    private void dfs(Node root){
        if (root==null)
            return;
        //中序遍历
        dfs(root.left);
        if (prev==null){
            //保存头节点
            head=root;
        }else {
            //链表指针
            prev.right=root;
            root.left=prev;
        }
        prev=root;
        dfs(root.right);
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


