package com.alg.algorithms.leetcode.alg100;

import java.util.*;

/**
 * 算法31-40
 */
public class Alg40 {
    List<List<Integer>> resultList = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

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
     * 34.在排序数组中查找元素的第一个和最后一个位置
     * 使用标准的二分查找统一
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange_2(int[] nums, int target) {
        if (null==nums || nums.length==0) return new int[]{-1,-1};
        int leftIndex = findLeft(nums , target);
        if (leftIndex==-1) return new int[]{-1,-1};
        int rightIndex = findRight(nums , target);

        return new int[]{leftIndex , rightIndex};
    }

    /**
     * 二分查找--左边界--标准
     * @param nums
     * @param target
     * @return
     */
    private int findLeft(int[] nums, int target) {
        int low=0,high=nums.length-1;
        while (low<=high){
            int middle = low+ (high-low)/2;
            if (nums[middle]==target){
                high=middle-1;
            }else if (nums[middle]>target){
                high=middle-1;
            }else {
                low=middle+1;
            }
        }
        if (low>= nums.length) return -1;
        return nums[low]==target?low:-1;
    }

    /**
     * 二分查找--右边界--标准
     * @param nums
     * @param target
     * @return
     */
    private int findRight(int[] nums, int target) {
        int low=0,high=nums.length-1;
        while (low<=high){
            int middle = low+ (high-low)/2;
            if (nums[middle]==target){
                low=middle+1;
            }else if (nums[middle]>target){
                high=middle-1;
            }else {
                low=middle+1;
            }
        }

        // 此时 left - 1 索引越界
        if (high>= nums.length) return -1;
        // 判断一下 nums[left] 是不是 target
        return nums[high] == target ? (high) : -1;
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
     * 空间复杂度：O(M),M为结果中的最长值
     * 时间复杂度：O(N*M),N为n
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
     * 38.外观数列
     * 递归方式
     * 空间复杂度：O(M),M为结果中的最长值
     * 时间复杂度：O(N*M),N为n
     * @param n
     * @return
     */
    public String countAndSay_2(int n){
        if (n==1) return "1";
        //递归:fn=f(fn-1)
        String str = countAndSay_2(n-1);

        StringBuilder sb = new StringBuilder();
        int k=0;
        while (k<str.length()){
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
        return sb.toString();
    }

    /**
     * 39.组合总和
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    /**
     * 39.组合总和
     * 回溯
     * 时间复杂度：O()
     * 空间复杂度：O(target)
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum_2(int[] candidates, int target){
        dfsSum(candidates , 0 , target);
        return resultList;
    }

    /**
     * 40.组合总和II（good）
     * 回溯
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfsSum2(candidates,0,target);
        return resultList;
    }


    private void dfsSum2(int[] candidates, int start, int target){
        if (0==target){
            resultList.add(new ArrayList<>(list));
        }
        for (int j=start;j<candidates.length;j++){
            //和前值相同时，跳过（巧妙的跳过方式）
            if (j>start && candidates[j]==candidates[j-1])
                continue;
            if (target-candidates[j]>=0){
                list.add(candidates[j]);
                dfsSum2(candidates,j+1,target-candidates[j]);
                list.remove(list.size()-1);
            }else {
                //剪枝：当前值和已经超过target,后续不可能有结果，直接跳过
                break;
            }
        }
    }

    private void dfsSum(int[] candidates, int start, int target){
        if (0==target){
            resultList.add(new ArrayList<>(list));
        }else if (target<0){
            return;
        }
        for (int j=start;j< candidates.length;j++){
            list.add(candidates[j]);
            dfsSum(candidates,j,target-candidates[j]);
            list.remove(list.size()-1);
        }
    }

    /**
     * @param candidates 候选数组
     * @param begin      搜索起点
     * @param len        冗余变量，是 candidates 里的属性，可以不传
     * @param target     每减去一个元素，目标值变小
     * @param path       从根结点到叶子结点的路径，是一个栈
     * @param res        结果集列表
     */
    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        // target 为负数和 0 的时候不再产生新的孩子结点
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 重点理解这里从 begin 开始搜索的语意
        for (int i = begin; i < len; i++) {
            path.addLast(candidates[i]);

            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs(candidates, i, len, target - candidates[i], path, res);

            // 状态重置
            path.removeLast();
        }
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
