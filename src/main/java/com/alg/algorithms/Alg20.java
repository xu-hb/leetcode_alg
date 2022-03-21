package com.alg.algorithms;

/**
 * 算法11-20
 */
public class Alg20 {
    /**
     * 11.盛最多水的容器
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i=0;i<height.length;i++){
            for (int j=i+1;j<height.length;j++){
                int temp = Math.min(height[i] , height[j]) * (j-i);
                maxArea = Math.max(temp , maxArea);
            }
        }
        return maxArea;
    }

    /**
     * 11.盛最多水的容器
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     * @param height
     * @return
     */
    public int maxArea_2(int[] height) {
        int maxArea = 0;
        int head=0, tail=height.length-1;
        while (tail>head){
            //计算当前面积
            int temp = Math.min(height[head] , height[tail]) * (tail-head);
            maxArea = Math.max(temp , maxArea);
            //值小的指针移动
            if (height[head] > height[tail]){
                tail--;
            }else {
                head++;
            }
        }
        return maxArea;
    }

}
