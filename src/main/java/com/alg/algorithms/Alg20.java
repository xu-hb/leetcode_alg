package com.alg.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * 算法11-20
 */
public class Alg20 {
    /**
     * 11.盛最多水的容器
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i=0;i<height.length;i++){
            for (int j=i+1;j<height.length;j++){
                int temp = Math.min(height[i] , height[j]) * (j-i);
                maxArea = Math.max(temp , maxArea);
            }
        }
        return maxArea;
    }

    /**
     * 11.盛最多水的容器
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     * @param height
     * @return
     */
    public int maxArea_2(int[] height) {
        int maxArea = 0;
        int head=0, tail=height.length-1;
        while (tail>head){
            //计算当前面积
            int temp = Math.min(height[head] , height[tail]) * (tail-head);
            maxArea = Math.max(temp , maxArea);
            //值小的指针移动
            if (height[head] > height[tail]){
                tail--;
            }else {
                head++;
            }
        }
        return maxArea;
    }

    /**
     * 12.整数转罗马数字
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] values = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i=0; i<values.length; i++){
            while (num>=values[i]){
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

    /**
     * 13.罗马数字转整数
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        Map<Character , Integer> map = new HashMap<>();
        map.put('I' , 1);
        map.put('V' , 5);
        map.put('X' , 10);
        map.put('L' , 50);
        map.put('C' , 100);
        map.put('D' , 500);
        map.put('M' , 1000);

        int result = 0;
        for (int i=0;i<s.length()-1;i++){
            int v1 = map.get(s.charAt(i));
            int v2 = map.get(s.charAt(i+1));
            if (v1<v2){
                result -=v1;
            }else {
                result +=v1;
            }
        }
        result += map.get(s.charAt(s.length()-1));
        return result;
    }

    /**
     * 14.最长公共前缀
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        String first = strs[0];

        for (int i=0; i<first.length();i++){
            for (int j=1;j<strs.length;j++){
                if (i>=strs[j].length() || first.charAt(i)!=strs[j].charAt(i)){
                    return first.substring(0,i);
                }
            }
        }
        return first;
    }
}
