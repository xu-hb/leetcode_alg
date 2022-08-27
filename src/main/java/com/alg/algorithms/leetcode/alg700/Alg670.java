package com.alg.algorithms.leetcode.alg700;

import com.alg.common.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Alg670 {
    /**
     * 662.二叉树最大宽度
     * BFS
     * 时间复杂度：O(N)
     * 空间复杂度：O(logN)
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        Deque<BiNode> deque = new LinkedList<>();
        deque.addLast(new BiNode(root,1));
        int max = 1;
        while (! deque.isEmpty()){
            int size = deque.size();
            if (size>1){
                max = Math.max(max , deque.getLast().idx - deque.getFirst().idx +1);
            }
            while (size-- >0){
                BiNode node = deque.pollFirst();
                if (node.node.left !=null) deque.addLast(new BiNode(node.node.left,2*node.idx));
                if (node.node.right !=null) deque.addLast(new BiNode(node.node.right,2*node.idx +1));
            }
        }
        return max;
    }

    class BiNode{
        TreeNode node;
        int idx;

        public BiNode(TreeNode node,int idx){
            this.node=node;
            this.idx=idx;
        }
    }

    /**
     * 670.最大交换
     * @param num
     * @return
     */
    public int maximumSwap(int num) {
        char[] origin = String.valueOf(num).toCharArray();
        char[] sorted = String.valueOf(num).toCharArray();
        int n = sorted.length;
        Arrays.sort(sorted);
        int i=0,j=n-1;
        for (;i<n;i++,j--){
            if (origin[i] !=sorted[j]){
                break;
            }
        }
        if (i<n){
            char temp = origin[i];
            origin[i]=sorted[j];
            for (int k=n-1;k>=0;k--){
                if (origin[k]==sorted[j]){
                    origin[k]=temp;
                    break;
                }
            }
        }
        return Integer.parseInt(String.valueOf(origin));
    }
}
