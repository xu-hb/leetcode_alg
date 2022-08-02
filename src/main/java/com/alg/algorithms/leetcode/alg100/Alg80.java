package com.alg.algorithms.leetcode.alg100;

import java.util.ArrayList;
import java.util.List;

public class Alg80 {
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    /**
     * 77.组合
     * 回溯
     * 时间复杂度：O(n^k)
     * 空间复杂度：O(N)
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        reverse(1,n,k);
        return result;
    }

    /**
     * 78.子集
     * 回溯
     * 时间复杂度：O(n*2^n)
     * 空间复杂度：O(N)
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        for (int i=0;i<=nums.length;i++){
            dfsSub(nums,0,i);
        }
        return result;
    }

    /**
     * 子集(78)的dfs
     * @param nums
     * @param start
     * @param depth
     */
    private void dfsSub(int[] nums, int start , int depth) {
        if (depth==0){
            result.add(new ArrayList<>(list));
            return;
        }
        //遍历
        for (int k=start;k<nums.length;k++){
            list.add(nums[k]);
            dfsSub(nums , k+1,depth-1);
            list.remove(list.size()-1);
        }
    }

    public void reverse(int start , int n , int k){
        if (k==0){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int j=start;j<=n;j++){
            list.add(j);
            reverse(j+1,n,k-1);
            list.remove(list.size()-1);
        }
    }
}
