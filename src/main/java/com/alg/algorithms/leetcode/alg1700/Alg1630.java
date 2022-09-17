package com.alg.algorithms.leetcode.alg1700;

import java.util.Arrays;

public class Alg1630 {

    /**
     * 1624.两个相同字符之间的最长子字符串
     * 时间复杂度：O(N)
     * 空间复杂度：O(C)
     * @param s
     * @return
     */
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] loc = new int[26];
        Arrays.fill(loc,-1);

        int ret=-1;
        for (int i=0;i<s.length();i++){
            if (loc[s.charAt(i)-'a'] !=-1){
                ret = Math.max(ret,i-loc[s.charAt(i)-'a']-1);
            }else {
                loc[s.charAt(i)-'a']=i;
            }
        }
        return ret;
    }

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
