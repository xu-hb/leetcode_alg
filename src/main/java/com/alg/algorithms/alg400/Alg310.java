package com.alg.algorithms.alg400;

public class Alg310 {

    int[] nums =null;
    int[][] calMatrix=null;

//    public Alg310(int[] nums) {
//        this.nums = nums;
//    }
    /**
     * 303.区域和检索-数组不可变
     * 时间复杂度：O(N)
     * @param left
     * @param right
     * @return
     */
    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i=left;i<=right;i++){
            sum+=nums[i];
        }
        return sum;
    }

    /**
     * 303.区域和检索-数组不可变 II
     * 前缀和，提前求和
     * 时间复杂度:O(1)
     * @param left
     * @param right
     * @return
     */
    public int sumRange_2(int left, int right){
        return nums[right+1] - nums[left];
    }

    public Alg310(int[] n) {
        //计算和
        this.nums = new int[n.length+1];
        for (int i=1;i<nums.length;i++){
            nums[i] = nums[i-1] + n[i-1];
        }
    }

    /**
     * 304.二维区域和检索-数组不可变
     * @param row1
     * @param col1
     * @param row2
     * @param col2
     * @return
     */
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i=row1;i<=row2;i++){
            sum+=calMatrix[i][col2+1]-calMatrix[i][col1];
        }
        return sum;
    }

    public Alg310(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        this.calMatrix = new int[m][n+1];
        for (int i=0;i<m;i++){
            for (int j=1;j<n+1;j++){
                calMatrix[i][j] = calMatrix[i][j-1] + matrix[i][j-1];
            }
        }
    }
}
