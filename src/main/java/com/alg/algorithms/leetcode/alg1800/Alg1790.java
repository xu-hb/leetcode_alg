package com.alg.algorithms.leetcode.alg1800;

public class Alg1790 {
    /**
     * 1790.仅执行一次字符串交换能否使两个字符串相等
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param s1
     * @param s2
     * @return
     */
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        //q、p分别记录不同的两处索引位置
        int diffCnt=0,q=-1,p=-1;
        for (int i=0;i<s1.length();i++){
            if (s1.charAt(i)==s2.charAt(i))
                continue;

            if (++diffCnt>2)return false;
            if (q==-1) q=i;
            else if (p==-1) p=i;
        }
        //全相等 || 两处对应相等
        return diffCnt==0 || (diffCnt==2 && s1.charAt(q)==s2.charAt(p) && s1.charAt(p)==s2.charAt(q));
    }
}
