package com.alg.algorithms.alg200;

import java.util.Stack;

public class Alg160 {
    /**
     * 151.颠倒字符串中的单词
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        int left=0,right=s.length()-1;
        //入栈
        Stack<String> stack = new Stack<>();
        //去除开头字符串
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }
        //去除结尾字符串
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }
        //入栈
        StringBuilder word = new StringBuilder();
        while (left<=right){
            char c = s.charAt(left);
            if (word.length()!=0 && c==' '){
                stack.push(word.toString());
                word.setLength(0);
            }else if (c !=' '){
                word.append(c);
            }
            left++;
        }
        stack.push(word.toString());

        word.setLength(0);
        while (stack.size()>0){
            word.append(stack.pop()).append(" ");
        }

        return word.delete(word.length()-1,word.length()).toString();
    }
}
