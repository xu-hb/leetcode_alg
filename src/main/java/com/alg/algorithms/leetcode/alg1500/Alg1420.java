package com.alg.algorithms.leetcode.alg1500;

public class Alg1420 {
    /**
     * 1413.逐步求和得到正数的最小值
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int minStartValue(int[] nums) {
        int min = nums[0];
        for (int i=1;i<nums.length;i++){
            //累计和
            nums[i] += nums[i-1];
            min = Math.min(min , nums[i]);
        }
        return 1-min>0 ? 1-min : 1;
    }

    /**
     * 1417.重新格式化字符串
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param s
     * @return
     */
    public String reformat(String s) {
        char[] digital = new char[s.length()];
        char[] letter = new char[s.length()];
        int dIdx=-1,lIdx=-1;
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                letter[++lIdx]=c;
            }else {
                digital[++dIdx]=c;
            }
        }
        if (Math.abs(lIdx-dIdx)>=2){
            return "";
        }

        boolean dFirst = dIdx>lIdx;
        StringBuilder sb = new StringBuilder();
        while (dIdx>=0 || lIdx>=0){
            if (dFirst){
                if (dIdx>=0)
                    sb.append(digital[dIdx--]);
                if (lIdx>=0)
                    sb.append(letter[lIdx--]);
            }else {
                if (lIdx>=0)
                    sb.append(letter[lIdx--]);
                if (dIdx>=0)
                    sb.append(digital[dIdx--]);
            }
        }
        return sb.toString();
    }

    /**
     * 1417.重新格式化字符串 2.0
     * 代码优化
     * @param s
     * @return
     */
    public String reformat_2(String s) {
        int sumDigit = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                sumDigit++;
            }
        }
        int sumAlpha = s.length() - sumDigit;
        if (Math.abs(sumDigit - sumAlpha) > 1) {
            return "";
        }
        boolean flag = sumDigit > sumAlpha;
        char[] arr = s.toCharArray();
        for (int i = 0, j = 1; i < s.length(); i += 2) {
            if (Character.isDigit(arr[i]) != flag) {
                while (Character.isDigit(arr[j]) != flag) {
                    j += 2;
                }
                swap(arr, i, j);
            }
        }
        return new String(arr);
    }

    public void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
}
