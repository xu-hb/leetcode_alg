package com.alg.algorithms.alg700;

import com.alg.common.TreeNode;

public class Alg660 {
    /**
     * 654.最大二叉树
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums , 0 , nums.length);
    }

    /**
     * 构建二叉树
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start>=end){
            return null;
        }
        //寻找最大值
        int maxVal = nums[start];
        int maxIndex = start;
        for (int i=start;i<end;i++){
            if (nums[i]>maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        TreeNode node = new TreeNode(maxVal);
        //构建左子树
        node.left = buildTree(nums , start , maxIndex);
        //构建右子树
        node.right = buildTree(nums , maxIndex+1 , end);
        return node;
    }
}
