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
}
