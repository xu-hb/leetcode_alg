package com.alg.design.queue;
/**
 * 622.循环队列
 * 基于数组
 */
public class MyCircularQueue_2 {
    int cap,head,tail;
    int[] num;

    public MyCircularQueue_2(int k) {
        this.cap = k;
        num = new int[cap];
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        num[tail++ %cap]=value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        head++;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return num[head%cap];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return num[(tail-1)%cap];
    }

    public boolean isEmpty() {
        return head==tail;
    }

    public boolean isFull() {
        return tail-head==cap;
    }
}
