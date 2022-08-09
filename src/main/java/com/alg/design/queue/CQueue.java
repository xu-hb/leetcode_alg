package com.alg.design.queue;

import java.util.Stack;

/**
 * 9.用两个栈实现队列
 */
public class CQueue {
    Stack<Integer> inStack; //入栈
    Stack<Integer> outStack; //出栈

    public CQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /**
     * 队列尾部插入
     * @param value
     */
    public void appendTail(int value) {
        inStack.push(value);
    }

    /**
     * 队列头删除
     * @return
     */
    public int deleteHead() {
        if (! outStack.isEmpty()){
            return outStack.pop();
        }
        transfer();
        return outStack.isEmpty() ? -1 : outStack.pop();
    }

    /**
     * 入栈转移到出栈
     */
    private void transfer(){
        while (! inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
    }
}
