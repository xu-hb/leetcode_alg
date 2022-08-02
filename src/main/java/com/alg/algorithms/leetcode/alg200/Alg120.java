package com.alg.algorithms.leetcode.alg200;

import com.alg.common.Node;
import com.alg.common.TreeNode;

import java.util.*;

public class Alg120 {

    /**
     * 114.二叉树展开为链表
     * @param root
     */
    public void flatten(TreeNode root) {
        if (null==root)
            return;
        rebuildNode(root);
    }

    /**
     * 树转单链表
     * @param root
     */
    private void rebuildNode(TreeNode root){
        if (root==null)
            return;

        //后序遍历
        rebuildNode(root.left);
        rebuildNode(root.right);
        //记录旧节点
        TreeNode oldR = root.right;
        TreeNode oldL = root.left;

        //左树置为右树的前驱结点
        root.right = oldL;
        root.left=null;

        //原右子树置为新右子树的右节点
        TreeNode temp = root;
        while (temp.right !=null){
            temp = temp.right;
        }
        temp.right=oldR;
    }

    /**
     * 116.填充每个节点的下一个右侧节点指针
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (null == root)
            return root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            while (len>0){
                Node node = queue.poll();
                Node next = queue.peek();
                if (null != next && len>1){
                    //同层最后一个元素指向null
                    node.next=next;
                }else {
                    node.next=null;
                }

                if (node.left !=null) queue.add(node.left);
                if (node.right !=null) queue.add(node.right);
                len--;
            }
        }
        return root;
    }

    /**
     * 116.填充每个节点的下一个右侧节点指针 2
     * 递归
     * @param root
     * @return
     */
    public Node connect_2(Node root){
        if (null==root){
            return root;
        }
        traverser(root.left , root.right);
        return root;
    }

    public void traverser(Node node1 , Node node2){
        if (node1==null || node2==null){
            return;
        }
        node1.next = node2;
        traverser(node1.left,node1.right);
        traverser(node2.left,node2.right);
        traverser(node1.right,node2.left);
    }

    /**
     * 118.杨辉三角
     * DP
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result =new ArrayList<>(numRows);
        //dp数组初始化值
        List<Integer> list = Collections.singletonList(1);
        result.add(list);
        if (numRows==1){
            return result;
        }
        List<Integer> list2 = Arrays.asList(1,1);
        result.add(list2);
        if (numRows==2){
            return result;
        }

        //遍历顺序
        for (int i=3;i<=numRows;i++){
            //dp:列的值
            List<Integer> dp = new ArrayList<>();
            for (int j=1;j<=i;j++){
                if (j==1 || j==i)
                    dp.add(1);
                else {
                    //递推：上层V(i-1)+V(i)
                    int temp = result.get(i-1-1).get(j-2) + result.get(i-1-1).get(j-1);
                    dp.add(temp);
                }
            }
            result.add(dp);
        }
        return result;
    }
}
