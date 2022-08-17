package com.alg.algorithms.leetcode.alg1400;

import com.alg.common.TreeNode;

public class Alg1310 {
    /**
     * 1302.层数最深叶子节点的和
     * @param root
     * @return
     */
    public int deepestLeavesSum(TreeNode root) {
        maxDepth=-1;
        sum=0;
        deepestLeavesSum(root,0);
        return sum;
    }
    int maxDepth;
    int sum;
    private void deepestLeavesSum(TreeNode root , int depth){
        if (root==null)
            return;
        depth+=1;
        deepestLeavesSum(root.left,depth);
        if (depth>maxDepth){
            maxDepth=depth;
            sum= 0;
        }
        if (depth==maxDepth){
            sum+= root.val;
        }
        deepestLeavesSum(root.right,depth);
    }
}
