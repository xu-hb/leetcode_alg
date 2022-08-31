package com.alg.algorithms.leetcode.alg1000;

import java.util.Stack;

public class Alg950 {

    /**
     * 946.验证栈序列
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        int cur=0;
        Stack<Integer> stack = new Stack<>();
        for (int v : pushed){
            stack.push(v);
            while (!stack.isEmpty() && stack.peek()==popped[cur]){
                stack.pop();
                cur++;
            }
        }
        if (stack.isEmpty() && cur==n) return true;
        return false;
    }
}
