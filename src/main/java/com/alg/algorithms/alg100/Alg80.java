package com.alg.algorithms.alg100;

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
