package com.alg.algorithms.leetcode.alg200;

import com.alg.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Alg200 {
    /**
     * 191.二进制中1的个数
     * 时间复杂度：O(N) N为n的二进制位数
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int cnt=0;
        int k=1;
        for (int i=0;i<32;i++){
            if ((n&k)!=0){
                cnt++;
            }
            k<<=1;
        }
        return cnt;
    }

    /**
     * 191.二进制中1的个数 2.0
     * 时间复杂度：O(M),M为n中1的个数
     * @param n
     * @return
     */
    public int hammingWeight_2(int n) {
        int cnt=0;
        while (n!=0){
            cnt++;
            //(n-1)&n会将最后一个1置为0
            n = (n-1) & n;
        }
        return cnt;
    }

    /**
     * 198.打家劫舍
     * DP
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        //dp:到第i家抢劫的金额
        int[] dp = new int[nums.length];
        //初始化
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            //递推公式
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }

    /**
     * 199.二叉树的右视图
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (null==root){
            return resList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (! queue.isEmpty()){
            int len = queue.size();
            int lastVal = 0;
            //遍历同一层级
            while (len>0){
                TreeNode node = queue.poll();
                lastVal = node.val;
                if (null != node.left) queue.add(node.left);
                if (null != node.right) queue.add(node.right);
                len--;
            }
            resList.add(lastVal);
        }
        return resList;
    }
}
