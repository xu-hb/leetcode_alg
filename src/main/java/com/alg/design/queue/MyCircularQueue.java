package com.alg.design.queue;

import com.alg.design.cache.DoubleList;
import com.alg.design.cache.Node;

/**
 * 622.循环队列
 */
public class MyCircularQueue {
    //容量
    private int cap;
    //双向队列
    private DoubleList<Integer,Integer> doubleList;

    public MyCircularQueue(int k) {
        cap = k;
        doubleList = new DoubleList<>();
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;
        Node<Integer,Integer> node = new Node<>(value ,value);
        doubleList.addLast(node);
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        Node node = doubleList.getFirst();
        doubleList.remove(node);
        return true;
    }

    public int Front() {
        if (isEmpty())
            return -1;
        return doubleList.getFirst().val;
    }

    public int Rear() {
        if (isEmpty())
            return -1;
        return doubleList.getLast().val;
    }

    public boolean isEmpty() {
        return doubleList.getSize()==0;
    }

    public boolean isFull() {
        return cap== doubleList.getSize();
    }
}
