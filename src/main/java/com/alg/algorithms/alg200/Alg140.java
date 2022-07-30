package com.alg.algorithms.alg200;

import java.util.*;

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

    /**
     * 136.只出现一次的数字
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        if (nums.length==1)
            return nums[0];

        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++){
            if (i%2==0) continue;
            if (nums[i] !=nums[i-1]) return nums[i-1];
        }
        //一个元素
        return nums[nums.length-1];
    }

    /**
     * 136.只出现一次的数字 2.0
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @return
     */
    public int singleNumber_2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums){
            if (set.contains(n)){
                set.remove(n);
            }else {
                set.add(n);
            }
        }
        return set.iterator().next();
    }

    /**
     * 136.只出现一次的数字 3.0
     * 使用异或（异或满足交换律；0^n=n; n^n=0）
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int singleNumber_3(int[] nums) {
        int res = 0;
        for (int n :nums){
            res ^= n;
        }
        return res;
    }
}
