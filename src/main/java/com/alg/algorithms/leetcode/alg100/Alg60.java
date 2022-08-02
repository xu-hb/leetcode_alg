package com.alg.algorithms.leetcode.alg100;

public class Alg60 {
    /**
     * 53.最大子数组之和
     * 贪心算法
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int max = nums[0];
        int sum = nums[0];
        for (int i=1;i<nums.length;i++){
            //贪心，负值只会拉低最大值。贪心每次的和>0
            if (sum>0){
                sum+=nums[i];
            }else {
                sum=nums[i];
            }
            max=Math.max(max,sum);
        }
        return max;
    }

    /**
     * 53.最大子数组之和 2.0
     * DP
     * @param nums
     * @return
     */
    public int maxSubArray_2(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        //dp：下标i的最子数组之和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i=1;i<nums.length;i++){
            if (dp[i-1]>0){
                //递推公式：
                dp[i]=dp[i-1]+nums[i];
            }else {
                dp[i]=nums[i];
            }
        }

        //选出最大值
        int max=dp[0];
        for (int i=0;i<dp.length;i++){
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    /**
     * 53.最大子数组之和 3.0
     * DP
     * @param nums
     * @return
     */
    public int maxSubArray_3(int[] nums){
        if (nums.length==1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];
        for (int i=1;i< nums.length;i++){
            dp[i] = dp[i-1]>0 ? dp[i-1]+nums[i] : nums[i];
            result = Math.max(result , dp[i]);
        }
        return result;
    }

    /**
     * 53.最大子数组之和 4.0
     * DP :dp数组空间优化:O(N)->O(1)
     * @param nums
     * @return
     */
    public int maxSubArray_4(int[] nums){
        if (nums.length==1){
            return nums[0];
        }
        int dp = nums[0];
        int result = dp;
        for (int i=1;i< nums.length;i++){
            dp = dp >0 ? dp+nums[i] : nums[i];
            result = Math.max(result , dp);
        }
        return result;
    }

    /**
     * 55.跳跃游戏
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums.length==1){
            return true;
        }
        int maxJumpStep = 0;
        for (int i=0;i<=maxJumpStep;i++){
            //贪心：贪心局部能到达的最远距离，总体是否最远距离可达最后节点
            //nums[i]+i：当前值能到达的最远距离
            maxJumpStep = Math.max(maxJumpStep , nums[i]+i);
            if (maxJumpStep>=nums.length-1){
                return true;
            }
        }
        return false;
    }
}
