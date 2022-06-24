package com.alg.algorithms.Alg300;

import java.util.ArrayList;
import java.util.List;

public class Alg220 {
    List<List<Integer>> resultList = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    /**
     * 213.打家劫舍II
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        if (len == 1)
            return nums[0];
        return Math.max(robAction(nums, 0, len - 1), robAction(nums, 1, len));
    }

    int robAction(int[] nums, int start, int end) {
        int x = 0, y = 0, z = 0;
        for (int i = start; i < end; i++) {
            y = z;
            z = Math.max(y, x + nums[i]);
            x = y;
        }
        return z;
    }

    /**
     * 216.组合总和III
     * 回溯
     * 时间复杂度：O(n^k)
     * 空间复杂度：O(k)
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1,n,k);
        return resultList;
    }

    public void dfs(int start , int sum,int depth){
        if (depth==0){
            int temp = list.stream().mapToInt(Integer::intValue).sum();
            if (sum==temp){
                resultList.add(new ArrayList<>(list));
            }
            return;
        }
        for (int j=start;j<=9;j++){
            list.add(j);
            dfs(j+1,sum,depth-1);
            list.remove(list.size()-1);
        }
    }
}
