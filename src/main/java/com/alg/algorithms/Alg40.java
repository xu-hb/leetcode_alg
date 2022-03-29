package com.alg.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * 算法31-40
 */
public class Alg40 {
    /**
     * 31.下一个排列
     * 时间复杂度:O(N)
     * 空间复杂度:O(1)
     * @param nums
     */
    public void nextPermutation(int[] nums) {

        int cursor = nums.length -1;

        for (; cursor>0;cursor--){
            //第一次出现后值比前值大时
            if (nums[cursor] > nums[cursor-1]){
                int temp = nums[cursor-1];

                //遍历过的数组中不小于temp的最小值（此时是有序的，可以使用二分查找，此处为了简单）
                for (int j=nums.length-1;j>=cursor;j--){
                    if (nums[j]>temp){
                        //交换
                        nums[cursor-1] = nums[j];
                        nums[j]=temp;
                        break;
                    }
                }

                //cursor至末尾的数组升序值最小
                reverse(nums , cursor);
                return;
            }
        }

        //此时是最大队列，返回最小队列
        reverse(nums , 0);
    }

    /**
     * 31.下一个排列
     * 逻辑相同，代码简化
     * @param nums
     */
    public void nextPermutation_2(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    /**
     * 33.搜索旋转排序数组
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int low=0,high=nums.length-1;

        while (low<=high){
            int middle = (high+low)/2;
            if (nums[middle] == target){
                return middle;
            }
            //必然一边有序，一边部分有序，不断循环从有序中查找
            if (nums[middle]>=nums[low]){
                //左半边有序
                if (nums[low]<=target && target <=nums[middle]){
                    high = middle-1;
                }else {
                    low=middle+1;
                }
            }else {
                //右半边有序
                if (nums[middle]<=target && target<=nums[high]){
                    low = middle+1;
                }else {
                    high=middle-1;
                }
            }
        }
        return -1;
    }

    /**
     * 34.在排序数组中查找元素的第一个和最后一个位置
     * 时间复杂度:O(N)
     * 空间复杂度:O(1)
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if (null==nums || nums.length==0) return new int[]{-1,-1};
        //寻找最左/最右右两个值，返回下标
        int firstIndex = findFirst(nums , target);
        if (firstIndex==-1) return new int[]{-1,-1};
        int lastIndex = findLast(nums , target);

        return new int[]{firstIndex , lastIndex};
    }

    /**
     * 36.有效的数独
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        //校验小数独
        for (int i=1;i<=9;i+=3){
            for (int j=1;j<=9;j+=3){
                boolean flag = validateSmallSudo(board , i,i+2,j,j+2);
                if (!flag) return false;
            }
        }
        //校验大数独
        return validateBigSudo(board , 1,9,1,9);
    }

    /**
     * 36.有效的数独
     * 空间复杂度：O(1)
     * 时间复杂度：O(1)
     * @param board
     * @return
     */
    public boolean isValidSudoku_2(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][][] subBox = new int[3][3][9];
        for (int i=0;i<9;i++){
            for (int k=0;k<9;k++){
                char c = board[i][k];
                if (c!='.'){
                    int index = c-'0'-1;
                    row[i][index]++;
                    col[k][index]++;
                    subBox[i/3][k/3][index]++;

                    if (row[i][index]>1 || col[k][index]>1 || subBox[i/3][k/3][index]>1){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 38.外观数列
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        if (n==1) return sb.toString();
        n=n-1;
        for (int i=0;i<n;i++){
            String str = sb.toString();
            //重置上一轮结果
            sb = new StringBuilder();

            for (int k=0;k<str.length();){
                char c = str.charAt(k);
                int count=1;
                while (k+count<str.length() && c==str.charAt(k+count)){
                    ++count;
                }
                //拼接结果
                sb.append(count);
                sb.append(c);
                //遍历前进count
                k+=count;
            }
        }
        return sb.toString();
    }

    /**
     * 校验小数独
     * @param board
     * @param rowStart
     * @param rowEnd
     * @param colStart
     * @param colEnd
     * @return
     */
    private boolean validateSmallSudo(char[][] board , int rowStart , int rowEnd , int colStart , int colEnd) {
        Set<Character> set = new HashSet<>();
        //检查行
        for (int rowIndex = rowStart - 1; rowIndex < rowEnd; rowIndex++) {
            for (int k = colStart - 1; k < colEnd; k++) {
                char c = board[rowIndex][k];
                if (c == '.') continue;
                if (set.contains(c)) return false;
                else set.add(c);
            }
        }
        return true;
    }

    /**
     * 校验大数独
     * @param board
     * @param rowStart
     * @param rowEnd
     * @param colStart
     * @param colEnd
     * @return
     */
    private boolean validateBigSudo(char[][] board , int rowStart , int rowEnd , int colStart , int colEnd){
        //检查行
        for (int rowIndex=rowStart-1;rowIndex<rowEnd;rowIndex++){
            Set<Character> set = new HashSet<>();
            for (int k=colStart-1;k<colEnd;k++){
                char c = board[rowIndex][k];
                if (c=='.') continue;
                if (set.contains(c)) return false;
                else set.add(c);
            }
        }
        //检查列
        for (int colIndex=colStart-1;colIndex<colEnd;colIndex++){
            Set<Character> set = new HashSet<>();
            for (int k=rowStart-1;k<rowEnd;k++){
                char c = board[k][colIndex];
                if (c=='.') continue;
                if (set.contains(c)) return false;
                else set.add(c);
            }
        }
        return true;
    }

    /**
     * 查找第一个下标
     * @param nums
     * @param target
     * @return
     */
    private int findFirst(int[] nums , int target){
        int low=0,high=nums.length-1;
        //最左的符合条件的值
        while (low<high){
            int middle = (low+high)/2;
            if (nums[middle]==target){
                high=middle;
            }else if (nums[middle]<target){
                low=middle+1;
            }else {
                high=middle-1;
            }
        }
        if (nums[low]==target) return low;
        return -1;
    }

    /**
     * 查找最后一个下标
     * @param nums
     * @param target
     * @return
     */
    private int findLast(int[] nums , int target){
        int low=0,high=nums.length-1;
        while (low<high){
            //最右一个符合条件的值,+1使相邻时不会左滑
            int middle = (low+high+1)/2;
            if (nums[middle]==target){
                low=middle;
            }else if (nums[middle]<target){
                low=middle+1;
            }else {
                high=middle-1;
            }
        }
        if (nums[high]==target) return high;
        return -1;
    }

    private int binSearch(int[] nums , int low,int high, int target){
        while (low<=high){
            int middle = (low+high)/2;
            if (nums[middle]==target){
                return middle;
            }else if (nums[low]<nums[middle]){
                low = middle+1;
            }else {
                high = middle-1;
            }
        }
        return -1;
    }

    /**
     * 反转
     * @param nums
     * @param start
     */
    private void reverse(int[]nums , int start){
        int left = start,right = nums.length-1;
        while (left<right){
            swap(nums , left , right);
            left++;
            right--;
        }
    }

    /**
     * 交换
     * @param nums
     * @param i
     * @param k
     */
    private void swap(int[]nums , int i , int k){
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }
}
