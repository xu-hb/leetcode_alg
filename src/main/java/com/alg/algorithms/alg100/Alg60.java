package com.alg.algorithms.alg100;

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
            sum+=nums[i];
            max=Math.max(max,sum);
            //贪心，负值只会拉低最大值。贪心每次的和>0
            if (sum<0){
                sum=0;
            }
        }
        return max;
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
