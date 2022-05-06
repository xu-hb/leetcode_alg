package com.alg.algorithms.alg200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Alg120 {
    /**
     * 118.杨辉三角
     * DP
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result =new ArrayList<>(numRows);
        //dp数组初始化值
        List<Integer> list = Collections.singletonList(1);
        result.add(list);
        if (numRows==1){
            return result;
        }
        List<Integer> list2 = Arrays.asList(1,1);
        result.add(list2);
        if (numRows==2){
            return result;
        }

        //遍历顺序
        for (int i=3;i<=numRows;i++){
            //dp:列的值
            List<Integer> dp = new ArrayList<>();
            for (int j=1;j<=i;j++){
                if (j==1 || j==i)
                    dp.add(1);
                else {
                    //递推：上层V(i-1)+V(i)
                    int temp = result.get(i-1-1).get(j-2) + result.get(i-1-1).get(j-1);
                    dp.add(temp);
                }
            }
            result.add(dp);
        }
        return result;
    }
}
