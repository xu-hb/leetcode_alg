package com.alg.algorithms.alg1100;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Alg1050 {

    /**
     * 1046.最后一块石头的重量
     * @param stones
     * @return
     */
    public int lastStoneWeight(int[] stones) {
        //降序
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        for (int s : stones){
            queue.add(s);
        }
        while (queue.size()>1){
            int a = queue.poll();
            int b = queue.poll();
            if (a!=b){
                queue.offer(a-b);
            }
        }
        return queue.isEmpty()?0:queue.poll();
    }

    /**
     * 1047. 删除字符串中的所有相邻重复项
     * 栈
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param s
     * @return
     */
    public String removeDuplicates(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (stack.size()<1){
                stack.push(c);
            }else if (c==stack.peek()){
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        String str = "";
        //剩余的元素即为不重复的元素
        while (!stack.isEmpty()) {
            str = stack.pop() + str;
        }
        return str;
    }

    /**
     * 1047.删除字符串中的所有相邻重复项 2
     * 数组+指针
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param s
     * @return
     */
    public String removeDuplicates_2(String s){
        char[] arr = new char[s.length()];
        int cursor = -1;
        for (char c : s.toCharArray()){
            if (cursor>=0 && arr[cursor]==c){
                --cursor;
            }else {
                arr[++cursor]=c;
            }
        }
        return String.valueOf(arr, 0, cursor + 1);
    }
}
