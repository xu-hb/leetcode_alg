package com.alg.algorithms.alg1000;

import java.util.*;

public class Alg910 {
    /**
     * 904.水果成篮
     * 滑动窗口
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param fruits
     * @return
     */
    public int totalFruit(int[] fruits) {
        int low=0,high=0;
        int max = 0;
        Map<Integer , Integer> map = new HashMap<>();

        while (high<fruits.length){
            int val = fruits[high];
            if (!map.containsKey(val)){
                if (map.size()<2) {
                    map.put(val,1);
                    max = Math.max(max , high-low+1);
                    high++;
                }
                else {
                    if (map.get(fruits[low]) ==1){
                        map.remove(fruits[low]);
                    } else{
                        map.put(fruits[low],map.get(fruits[low])-1);
                    }
                    low++;
                    max = Math.max(max , high-low+1);
                }
            }else {
                max = Math.max(max , high-low+1);
                map.put(val , map.get(val)+1);
                high++;
            }
        }
        return max;
    }

    /**
     * 904.水果成篮
     * 滑动窗口 优化
     * @param fruits
     * @return
     */
    public int totalFruit_2(int[] fruits){
        int low=0;int high=0;int ans=0;
        int lVal = fruits[low];
        int hVal = fruits[high];
        while (high<fruits.length){
            if (fruits[high] == hVal || fruits[high]==lVal){
                //范围内，继续右移
                ans = Math.max(ans,high-low+1);
                high++;
            }else {
                //第三个数出现，倒退出high-1的值
                low=high-1;
                lVal=fruits[low];
                while (low>=1 && fruits[low-1]==lVal) low--;
                hVal=fruits[high];
                ans = Math.max(ans,high-low+1);
            }
        }
        return ans;
    }

    /**
     * 905.按奇偶排序数组
     * @param nums
     * @return
     */
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int low=0,high=n-1;
        while (low<high){
            if ((nums[low]&1)==1){
                while (high>low && (nums[high]&1)==1){
                    high--;
                }
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;

                high--;
            }
            low++;
        }
        return nums;
    }
}
