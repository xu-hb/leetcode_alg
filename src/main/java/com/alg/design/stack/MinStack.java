package com.alg.design.stack;

import java.util.List;
import java.util.Map;

/**
 * offer 30.包含min函数的栈
 */
public class MinStack {
    Node head;
    public MinStack() {
    }

    public void push(int val) {
        if (head==null){
            head = new Node(val , val, head);
        }else {
            head = new Node(val , Math.min(val , head.min) , head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}

class Node{
    public int val;
    public int min;
    public Node next;

    public Node(){}

    public Node(int v , int m, Node next){
        this.val = v;
        this.min = m;
        this.next = next;
    }
}
