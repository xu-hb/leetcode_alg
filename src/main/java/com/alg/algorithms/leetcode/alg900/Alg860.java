package com.alg.algorithms.leetcode.alg900;

import java.util.ArrayDeque;
import java.util.Deque;

public class Alg860 {

    /**
     * 856.括号的分数
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param s
     * @return
     */
    public int scoreOfParentheses(String s) {
        Deque<Integer> deque = new ArrayDeque<>();
        //初始默认值0
        deque.push(0);
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='(')
                deque.push(0);
            else {
                int v = deque.pop();
                //AB=A+B在初始值为0时直接相加；()和(A)统一处理为：Math.max(2*v,1)
                int res = deque.pop() + Math.max(2*v,1);
                deque.push(res);
            }
        }
        return deque.peek();
    }

    /**
     * 860.柠檬水找零
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                if (five == 0)
                    return false;
                five--;
                ten++;
            } else {
                //贪心:5元具有更大流通性，优先存放5元使用大额找零
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
