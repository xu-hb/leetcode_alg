package com.alg.algorithms.leetcode.alg100;

/**
 * 算法41-50
 */
public class Alg50 {
    /**
     * 43.字符串相乘
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(m+n)
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int m = num1.length();
        int n = num2.length();
        //乘积最大位数m+n
        int[] result = new int[m+n];

        for (int i=m-1; i>=0;i--){
            int x = num1.charAt(i)-'0';
            for (int k=n-1; k>=0; k--){
                int y = num2.charAt(k) - '0';
                //竖式乘积和
                result[i+k+1] += x*y;
            }
        }

        //进位
        for (int k = result.length-1; k>=0;k--){
            int val = result[k];
            if (val>=10){
                result[k-1] += val/10;
                result[k] = val%10;
            }
        }
        //高位去0
        int cursor = result[0] ==0 ? 1 : 0;
        StringBuilder sb = new StringBuilder();
        for (;cursor<result.length;cursor++){
            sb.append(result[cursor]);
        }

        return sb.toString();
    }

    /**
     * 45.跳跃游戏2
     * 时间复杂度：O(N)
     * 空间复杂度:O(1)
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int end =0;
        int steps = 0;
        int max = 0;

        for (int i=0;i<nums.length-1;i++){
            max = Math.max(max , nums[i]+i);
            if (i==end){
                steps++;
                end=max;
            }
        }
        return steps;
    }

    /**
     * 48.旋转图像 Good
     * 通过对折快速旋转
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        //斜对线对折
        for (int i=0;i<matrix.length;i++){
            for (int j=i;j<matrix[i].length;j++){
                if (i !=j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        //竖线对折
        for (int i=0;i< matrix.length;i++){
            int left=0,right=matrix[i].length-1;
            while (left<right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}
