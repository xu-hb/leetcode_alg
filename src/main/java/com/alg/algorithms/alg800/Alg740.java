package com.alg.algorithms.alg800;

import java.util.Arrays;

public class Alg740 {
    /**
     * 738.单调递增的数字
     * 贪心
     * @param n
     * @return
     */
    public int monotoneIncreasingDigits(int n) {
        String str = String.valueOf(n);
        char[] charArr = str.toCharArray();
        int len = charArr.length;
        //记录索引
        int start=len;
        for (int i=len-1;i>0;i--){
            if (charArr[i]<charArr[i-1]){
                //局部最优：遇到strNum[i - 1] > strNum[i]的情况，让strNum[i - 1]--，然后strNum[i]给为9，可以保证这两位变成最大单调递增整数
                start=i;
                charArr[i-1]--;
            }
        }
        for (int j=start;j<len;j++){
            //退位后的补最大值9
            charArr[j]='9';
        }
        return Integer.parseInt(String.valueOf(charArr));
    }
}
