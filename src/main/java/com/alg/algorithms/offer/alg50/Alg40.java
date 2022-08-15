package com.alg.algorithms.offer.alg50;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Alg40 {
    /**
     * 31.栈的压入,弹出序列
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed==null || popped==null || pushed.length==0 || popped.length==0)
            return true;
        int n = pushed.length;
        int m = popped.length;
        int idxN=0,idxM=0;
        Stack<Integer> stack = new Stack<>();

        while (idxN<n && idxM<m){
            if (popped[idxM]==pushed[idxN]){
                //相等：idxM入栈并出栈
                idxM++;
                idxN++;
            }else {
                //不等
                int val = stack.isEmpty() ? -1 : stack.peek();
                if (val==popped[idxM]){
                    stack.pop();
                    idxM++;
                }else {
                    stack.push(pushed[idxN]);
                    idxN++;
                }
            }
        }

        //对比栈中剩余数据
        while (!stack.isEmpty() && idxM<m){
            if (stack.pop() != popped[idxM++]){
                return false;
            }
        }

        return stack.isEmpty() && idxN>=n && idxM>=m;
    }

    /**
     * 31.栈的压入,弹出序列
     * 代码简化
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences_2(int[] pushed, int[] popped){
        if (pushed==null || popped==null || pushed.length==0 || popped.length==0)
            return true;
        int idxM=0;
        Deque<Integer> deque = new LinkedList<>();
        for (int n : pushed){
            deque.push(n);
            while (idxM<popped.length && !deque.isEmpty() && deque.peek()==popped[idxM]){
                deque.pop();
                idxM++;
            }
        }
        return idxM== popped.length;
    }
}
