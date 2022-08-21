package com.alg.algorithms.leetcode.alg1500;

public class Alg1450 {
    /**
     * 1450.在既定时间作业的学生人数
     * @param startTime
     * @param endTime
     * @param queryTime
     * @return
     */
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int cnt = 0;
        for (int i=0;i<startTime.length;i++){
            if (startTime[i]<=queryTime && endTime[i]>=queryTime){
                cnt++;
            }
        }
        return cnt;
    }

    /**
     * 1455.检查单词是否为句中其他单词的前缀
     * 时间复杂度：O(n*m)
     * @param sentence
     * @param searchWord
     * @return
     */
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] arr = sentence.split(" ");
        for (int i=0;i<arr.length;i++){
            if (arr[i].startsWith(searchWord)){
                return i+1;
            }
        }
        return -1;
    }
}
