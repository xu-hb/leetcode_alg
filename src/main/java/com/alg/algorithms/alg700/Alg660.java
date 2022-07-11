package com.alg.algorithms.alg700;

import com.alg.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Alg660 {

    Map<String,Integer> count;
    List<TreeNode> result;
    /**
     * 652.寻找重复的子树
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap<>();
        result = new ArrayList<>();
        collect(root);
        return result;
    }
    private String collect(TreeNode node){
        if (node==null) return "#";
        //通过路径形成key，判定是否有相同结构和节点值
        String key = node.val+","+collect(node.left)+","+collect(node.right);
        count.put(key,count.getOrDefault(key,0)+1);
        if (count.get(key)==2){
            //重复的不纳入
            result.add(node);
        }
        return key;
    }

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
