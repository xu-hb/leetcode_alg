package com.alg.algorithms.Alg300;

public class Alg250 {
    /**
     * 242.有效的字母异位词
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] arr = new int[26];
        for (int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']+=1;
        }
        for (int i=0;i<t.length();i++){
            int index = t.charAt(i)-'a';
            arr[index]-=1;
            if (arr[index] <0) return false;
        }
        return true;
    }
}
