package com.alg.algorithms.alg900;

public class Alg860 {
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
