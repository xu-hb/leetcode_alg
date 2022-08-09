package com.alg.algorithms.leetcode.alg1500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Alg1410 {

    /**
     * 1403.非递增顺序的最小子序列
     * 时间复杂度：O(NlogN)
     * 空间复杂度: O(logN)
     * @param nums
     * @return
     */
    public List<Integer> minSubsequence(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int cal=0;
        for (int i=nums.length-1;i>=0;i--){
            cal+=nums[i];
            list.add(nums[i]);
            if (cal*2 > sum){
                return list;
            }
        }
        return list;
    }

    /**
     * 1403.非递增顺序的最小子序列 2.0
     * 计数排序
     * @param nums
     * @return
     */
    public List<Integer> minSubsequence_2(int[] nums){
        int M = 101;
        int sum =0;
        int[] count = new int[M];
        for (int n: nums){
            sum+=n;
            count[n]++;
        }

        int total=0;
        int idx= count.length-1;
        List<Integer> ans = new ArrayList<>();

        while (2*total<=sum){
            if (count[idx]>0){
                total+=idx;
                ans.add(idx);
                count[idx]--;
            }else {
                idx--;
            }
        }
        return ans;
    }

    /**
     * 1403.非递增顺序的最小子序列 3.0
     * 计数排序--缩小空间
     * 时间复杂度：O(N)
     * 空间复杂度：O(Max(nums))
     * @param nums
     * @return
     */
    public List<Integer> minSubsequence_3(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        int sum = Arrays.stream(nums).sum();

        int len = max - min +1;
        int[] arr = new int[len];
        for (int n : nums){
            arr[n-min] +=1;
        }
        List<Integer> result = new ArrayList<>();

        int total = 0;
        int idx = len-1;
        while (idx>=0){
            if (arr[idx] >0){
                total+=idx+min;
                result.add(idx+min);
                arr[idx]--;
            }else {
                idx--;
            }
            if (2*total>sum){
                return result;
            }
        }
        return result;
    }

    /**
     * 1408.数组中的字符串匹配
     * 时间复杂度：O(N^2*L^2)
     * 空间复杂度：O(1)
     * @param words
     * @return
     */
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }
}
