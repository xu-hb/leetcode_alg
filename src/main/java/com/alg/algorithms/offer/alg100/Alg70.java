package com.alg.algorithms.offer.alg100;

import com.alg.common.TreeNode;

public class Alg70 {

    /**
     * 61.扑克牌中的顺子
     * 时间复杂度：O(N)
     * 空间复杂度：O(C)
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        int[] repeat = new int[14];
        int max=0,min=16;
        for (int n : nums){
            if (n==0) {
                continue;
            }
            max = Math.max(max,n);
            min = Math.min(min,n);
            if (repeat[n]!=0)
                return false;
            repeat[n]++;
        }
        return max-min<5;
    }

    /**
     * 68-I.二叉搜索树的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        min = Math.min(pVal,qVal);
        max = Math.max(pVal,qVal);
        return search(root);
    }
    int min = 0;
    int max = 0;
    private TreeNode search(TreeNode root){
        while (root !=null){
            if (root.val>=min && root.val<=max){
                return root;
            }else if (max<= root.val){
                return search(root.left);
            }else if (min>= root.val){
                return search(root.right);
            }
        }
        return null;
    }
}
