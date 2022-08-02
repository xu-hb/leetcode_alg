package com.alg.algorithms.alg700;

import com.alg.design.queue.MyCircularQueue;
import com.alg.design.queue.MyCircularQueue_2;

public class Alg630 {
    /**
     * 622.设计循环队列
     * 链表
     * @see MyCircularQueue
     * @return
     */
    public MyCircularQueue circularQueue(){
        return new MyCircularQueue(1);
    }

    /**
     * 622.设计循环队列 2.0
     * 数组
     * @return
     */
    public MyCircularQueue_2 circularQueue_2(){
        return new MyCircularQueue_2(1);
    }
}
