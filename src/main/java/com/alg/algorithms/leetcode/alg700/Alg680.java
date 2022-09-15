package com.alg.algorithms.leetcode.alg700;

public class Alg680 {
    /**
     * 672.灯泡开关II
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     * @param n
     * @param presses
     * @return
     */
    public int flipLights(int n, int presses) {
        //不按开关
        if (presses == 0) {
            return 1;
        }
        //特殊情况处理
        if (n == 1) {
            return 2;
        } else if (n == 2) {
            //特殊情况
            return presses == 1 ? 3 : 4;
        } else {
            //n >= 3
            return presses == 1 ? 4 : presses == 2 ? 7 : 8;
        }
    }
}
