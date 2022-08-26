package com.alg.algorithms.leetcode.alg1700;

public class Alg1630 {
    /**
     * 1629.按键持续时间最长的键
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param releaseTimes
     * @param keysPressed
     * @return
     */
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char ret=keysPressed.charAt(0);
        int max=releaseTimes[0];
        for (int i=1;i<releaseTimes.length;i++){
            int dif = releaseTimes[i]-releaseTimes[i-1];
            if (dif==max){
                max = dif;
                ret = ret > keysPressed.charAt(i) ? ret : keysPressed.charAt(i);
            }else if (dif>max){
                max = dif;
                ret = keysPressed.charAt(i);
            }
        }
        return ret;
    }
}
