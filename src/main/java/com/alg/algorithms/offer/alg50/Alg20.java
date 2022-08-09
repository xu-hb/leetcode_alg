package com.alg.algorithms.offer.alg50;

public class Alg20 {
    /**
     * 11.旋转数组的最小数字
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        for (int i=1;i< numbers.length;i++){
            if (numbers[i]<numbers[i-1])
                return numbers[i];
        }
        return numbers[0];
    }
}
