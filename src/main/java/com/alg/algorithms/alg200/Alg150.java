package com.alg.algorithms.alg200;

import java.util.ArrayDeque;

public class Alg150 {

    /**
     * 150.逆波兰表达式求值
     * 栈
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (String str : tokens){
            switch (str){
                case "+" : deque.push(deque.pop()+deque.pop());
                break;
                case "-" :
                    int temp1 = deque.pop();
                    int temp2 = deque.pop();
                    deque.push(temp2-temp1);
                    break;
                case "*" : deque.push(deque.pop()*deque.pop());break;
                case "/" :
                    int temp3 = deque.pop();
                    int temp4 = deque.pop();
                    deque.push(temp4/temp3);
                    break;
                default:
                    deque.push(Integer.valueOf(str));
            }
        }
        return deque.pop();
    }
}
