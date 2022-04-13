package com.alg.algorithms.alg1100;

import java.util.ArrayDeque;

public class Alg1050 {
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
}
