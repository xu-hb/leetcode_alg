package com.alg.algorithms.Alg300;

import java.util.ArrayList;
import java.util.List;

public class Alg220 {
    List<List<Integer>> resultList = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
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
