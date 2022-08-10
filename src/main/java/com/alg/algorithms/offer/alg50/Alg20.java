package com.alg.algorithms.offer.alg50;

public class Alg20 {
    /**
     * 11.旋转数组的最小数字
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        for (int i=1;i< numbers.length;i++){
            if (numbers[i]<numbers[i-1])
                return numbers[i];
        }
        return numbers[0];
    }

    /**
     * 11.旋转数组的最小数字 2.0
     * 时间复杂度：O(logN)
     * 空间复杂度：O(1)
     * @param numbers
     * @return
     */
    public int minArray_2(int[] numbers) {
        int n = numbers.length;
        int l=0,r=n-1;
        while (l<r){
            int mid = l + (r-l)/2;
            //和右端点值比较，因为左端点不能区分出递增情况
            if (numbers[mid]>numbers[r]){
                l=mid+1;
            }else if (numbers[mid]<numbers[r]){
                r=mid;
            }else {
                //此时不能判定最小值在那个区间，缩小区间范围
                r=r-1;
            }
        }
        return numbers[r];
    }

    /**
     * 12.矩阵中的路径
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length;j++){
                if (exist(i,j,0))
                    return true;
            }
        }
        return false;
    }
    char[][] board;
    String word;
    private boolean exist(int rowIdx , int lineIdx , int strIdx) {
        if (strIdx>word.length()-1){
            return true;
        }
        if (rowIdx<0 || rowIdx>board.length-1 || lineIdx<0 || lineIdx>board[0].length-1){
            return false;
        }
        if (board[rowIdx][lineIdx]=='1'){
            return false;
        }
        char w = word.charAt(strIdx);

        if (board[rowIdx][lineIdx]==w){
            board[rowIdx][lineIdx]='1';
            boolean res = exist(rowIdx,lineIdx+1,strIdx+1) ||
                    exist(rowIdx+1,lineIdx,strIdx+1) ||
                    exist(rowIdx,lineIdx-1,strIdx+1) ||
                    exist(rowIdx-1,lineIdx,strIdx+1);
            if (! res)
                board[rowIdx][lineIdx]=w;
            return res;
        }else {
            return false;
        }
    }

    /**
     * 14-I.剪绳子
     * dp
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        //dp：k-绳子长度;v-最大乘积
        int[]dp = new int[n+1];
        dp[2] = 1;
        for (int i=3;i<=n;i++){
            for (int j=1;j<i;j++){
                dp[i] = Math.max(dp[i],Math.max(j*dp[i-j],j*(i-j)));
            }
        }
        return dp[n];
    }
}
