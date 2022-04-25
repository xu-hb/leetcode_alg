package com.alg.algorithms.alg200;

import java.util.ArrayList;
import java.util.List;

public class Alg140 {
    List<List<String>> resultList = new ArrayList<>();
    List<String> list = new ArrayList<>();
    /**
     * 131.分割回文串
     * 回溯
     * @param s
     * @return
     */
    int len;
    public List<List<String>> partition(String s) {
        len=s.length();
        dfsPartition(s,0);
        return resultList;
    }

    /**
     * 134.加油站
     * 贪心算法
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            //贪心：当前累加值大于0局部最优（小于0则从当前起点开始寻找新的局部最优）
            if (curSum < 0) {
                index = (i + 1) % gas.length ;
                curSum = 0;
            }
        }
        if (totalSum < 0) return -1;
        return index;
    }

    /**
     * 分割回文串dfs
     * @param s
     * @param size
     */
    private void dfsPartition(String s , int size){
        if (size==len){
            resultList.add(new ArrayList<>(list));
            return;
        }
        for (int i=0;i<s.length();i++){
            String str = s.substring(0,i+1);
            if (validatePalindrome(str)){
                list.add(str);
                String rightStr = s.substring(i+1);
                dfsPartition(rightStr,size+str.length());
                list.remove(list.size()-1);
            }
        }
    }

    /**
     * 回文串判断
     * @param s
     * @return
     */
    private boolean validatePalindrome(String s){
        if (null==s || "".equals(s)){
            return false;
        }
        int low = 0;
        int high = s.length()-1;
        while (low<=high &&  s.charAt(low)==s.charAt(high)){
           low++;
           high--;
        }
        return low >= high;
    }
}
