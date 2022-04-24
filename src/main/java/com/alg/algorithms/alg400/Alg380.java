package com.alg.algorithms.alg400;

public class Alg380 {
    /**
     * 376.摆动序列
     * 贪心算法
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums.length<=1){
            return nums.length;
        }
        int result=1;
        int curDiff=0;
        int preDiff=0;
        for (int k=1;k<nums.length;k++){
            curDiff=nums[k]-nums[k-1];
            //相同坡度，使用顶峰或谷底值比较(不用删除，忽略中间值即可)，寻求当前最优解
            if ((curDiff<0 && preDiff>=0)||(curDiff>0 && preDiff<=0)){
                result++;
                preDiff=curDiff;
            }
        }
        return result;
    }
}
