package com.alg.algorithms.alg400;

import com.alg.common.Pair;

import java.util.ArrayList;
import java.util.List;

public class Alg320 {
    /**
     * 315.计算右侧小于当前元素的个数
     * 暴力求解，时间复杂度：O(N^2)
     * 执行超时
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int i=0;i<nums.length;i++){
            int cnt=0;
            for (int j=i+1;j<nums.length;j++){
                if (nums[i]>nums[j])
                    cnt++;
            }
            list.add(cnt);
        }
        return list;
    }

    /**
     * 315.计算右侧小于当前元素的个数 2.0
     * 归并排序（使用对象存储值与索引的映射）
     * 时间复杂度：O(NlogN)
     * @param nums
     * @return
     */
    public List<Integer> countSmaller_2(int[] nums) {
        //初始化
        count = new int[nums.length];
        temps = new Pair[nums.length];
        Pair[] arr = new Pair[nums.length];
        List<Integer> result = new ArrayList<>(nums.length);
        //初始化 值-索引
        for (int i=0;i<nums.length;i++){
            arr[i] = new Pair(nums[i],i);
        }
        //归并排序
        sort(arr , 0 , nums.length-1);
        for (int c : count){
            result.add(c);
        }
        return result;
    }

    //右侧小于当前元素的数量
    int[] count=null;
    //暂存数组
    Pair[] temps=null;

    /**
     * 归并排序
     * @param arr
     * @param start
     * @param end
     */
    private void sort(Pair[] arr, int start, int end) {
        if (start==end)
            return;
        int middle = start + (end-start)/2;
        sort(arr,start,middle);
        sort(arr,middle+1,end);
        merge(arr, start , middle , end);
    }

    private void merge(Pair[] arr, int start, int middle, int end) {
        //暂存
        for (int i=start;i<=end;i++){
            temps[i]=arr[i];
        }

        int i=start,j=middle+1;
        for (int p=start;p<=end;p++){
            if (i==middle+1){
                arr[p]=temps[j++];
            }else if (j==end+1){
                arr[p]=temps[i++];
                count[arr[p].index]+=j-(middle+1);
            }else if (temps[i].val>temps[j].val){
                arr[p]=temps[j++];
            }else {
                arr[p]=temps[i++];
                count[arr[p].index]+=j-(middle+1);
            }
        }
    }
}
