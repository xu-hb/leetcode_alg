package com.alg.algorithms.alg400;

import com.alg.common.TreeNode;

import java.util.Arrays;


public class Alg300 {
    /**
     * 297.二叉树的序列化和反序列化
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializePre(root , sb);
        String result = sb.toString();
        //去除第一个逗号
        if (result.startsWith(",")){
            return result.substring(1);
        }
        return result;
    }
    public TreeNode deserialize(String data) {
        if (null==data || data.equals(""))
            return null;
        String[] origin = data.split(",");
        return deserializePre(origin , 0);
    }

    /**
     * 序列化--前序
     * @param root
     * @param sb
     */
    public void serializePre(TreeNode root , StringBuilder sb){
        if (null==root){
            sb.append(",").append("#");
            return;
        }
        sb.append(",").append(root.val);

        serializePre(root.left , sb);
        serializePre(root.right , sb);
    }
    //记录右子树开始索引
    int index = -1;
    /**
     * 反序列化--前序
     * @param origin
     * @param start
     * @return
     */
    private TreeNode deserializePre(String[] origin, int start) {
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

    /**
     * 300.最长递增子序列
     * dp
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
