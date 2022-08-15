package com.alg.design.deque;

import com.alg.design.cache.DoubleList;
/**
 * 641.设计循环双端队列
 */
public class MyCircularDeque {
    //双向链表
    private DoubleList<Integer,Integer> doubleList;
    //容量
    private int size;

    public MyCircularDeque(int k) {
        this.size = k;
        doubleList = new DoubleList<>();
    }

    public boolean insertFront(int value) {
        if (isFull())
            return false;
        doubleList.addFirst(value,value);
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull())
            return false;
        doubleList.addLast(value , value);
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty())
            return false;
        return doubleList.removeFirst() !=null;
    }

    public boolean deleteLast() {
        if (isEmpty())
            return false;
        return doubleList.removeLast() !=null;
    }

    public int getFront() {
        return isEmpty() ? -1 : doubleList.getFirst().val;
    }

    public int getRear() {
        return isEmpty() ? -1 : doubleList.getLast().val;
    }

    public boolean isEmpty() {
        return doubleList.getSize()==0;
    }

    public boolean isFull() {
        return doubleList.getSize()==size;
    }
}
