package com.alg.algorithms.leetcode.alg700;

import com.alg.design.deque.MyCircularDeque;
import com.alg.design.tree.Trie;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Alg650 {
    /**
     * 641.设计循环双端队列
     * @see MyCircularDeque
     * @return
     */
    public MyCircularDeque circularDeque(){
        MyCircularDeque circularDeque = new MyCircularDeque(5);
        circularDeque.insertFront(4);
        return circularDeque;
    }

    /**
     * 643.子数组最大平均数I
     * 滑动窗口
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        int window = 0;
        for (int i=0;i<k;i++){
            window+=nums[i];
        }
        int max = window;
        //滑动窗口
        for (int i=k;i< nums.length;i++){
            window += nums[i]-nums[i-k];
            //比当前值小直接忽略
            if (nums[i]<=nums[i-k]) continue;

            max = Math.max(max,window);
        }
        return max*1.0/k;
    }

    /**
     * 646.最长数对链
     * 时间复杂度：O(NlogN)
     * 空间复杂度：O(logN)
     * @param pairs
     * @return
     */
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));

        int cnt=1;
        int l1=pairs[0][1];
        for (int i=1;i< pairs.length;i++){
            if (pairs[i][0]>l1){
                cnt++;
                l1=pairs[i][1];
            }
        }
        return cnt;
    }

    /**
     * 648.单词替换
     * @param dictionary
     * @param sentence
     * @return
     */
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String dict : dictionary){
            trie.insert(dict);
        }
        String[] arr = sentence.split(" ");
        for (int i=0;i<arr.length;i++){
            String sen = arr[i];
            String matchPrefix = trie.minStartString(sen);
            if (matchPrefix !=null && !matchPrefix.equals("")){
                arr[i] = matchPrefix;
            }
        }
        return String.join(" ", arr);
    }
}
