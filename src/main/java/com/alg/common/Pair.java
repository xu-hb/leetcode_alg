package com.alg.common;

public class Pair {
    /**
     * 值
     */
    public int val;
    /**
     * 索引
     */
    public int index;
    public Pair(int val, int index) {
        // 记录数组的元素值
        this.val = val;
        // 记录元素在数组中的原始索引
        this.index = index;
    }
}
