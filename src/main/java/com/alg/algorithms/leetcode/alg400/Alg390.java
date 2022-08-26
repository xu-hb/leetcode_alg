package com.alg.algorithms.leetcode.alg400;

public class Alg390 {
    /**
     * 383.赎金信
     * 时间复杂度：O(N+M)
     * 空间复杂度：O(S)
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cntArr = new int[26];
        int lenA = ransomNote.length(),lenB=magazine.length();
        int curA = 0,curB=0;
        while (curA < lenA || curB<lenB){
            if (curA<lenA){
                cntArr[ransomNote.charAt(curA)-'a']++;
            }
            if (curB<lenB){
                cntArr[magazine.charAt(curB)-'a']--;
            }
            curA++;
            curB++;
        }
        for (int i=0;i< cntArr.length;i++){
            if (cntArr[i]>0)
                return false;
        }
        return true;
    }
}
