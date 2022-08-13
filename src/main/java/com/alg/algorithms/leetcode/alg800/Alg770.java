package com.alg.algorithms.leetcode.alg800;

import java.util.*;

public class Alg770 {
    /**
     * 761.特殊的二进制序列
     * @param s
     * @return
     */
    public String makeLargestSpecial(String s) {
        if (s.length() == 0) return s;
        List<String> list = new ArrayList<>();
        char[] cs = s.toCharArray();
        for (int i = 0, j = 0, k = 0; i < cs.length; i++) {
            k += cs[i] == '1' ? 1 : -1;
            if (k == 0) {
                list.add("1" + makeLargestSpecial(s.substring(j + 1, i)) + "0");
                j = i + 1;
            }
        }
        Collections.sort(list, (a, b)->(b + a).compareTo(a + b));
        StringBuilder sb = new StringBuilder();
        for (String str : list) sb.append(str);
        return sb.toString();
    }

    /**
     * 768.最多能完成排序的块II
     * @param arr
     * @return
     */
    public int maxChunksToSorted(int[] arr) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for(int num : arr) {
            if(!stack.isEmpty() && num < stack.getLast()) {
                int head = stack.removeLast();
                while(!stack.isEmpty() && num < stack.getLast()) stack.removeLast();
                stack.addLast(head);
            }
            else stack.addLast(num);
        }
        return stack.size();
    }
}
