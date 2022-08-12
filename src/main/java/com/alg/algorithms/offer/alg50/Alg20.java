package com.alg.algorithms.offer.alg50;

import com.alg.common.ListNode;

import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    /**
     * 15.二进制中1的个数
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int cnt=0;
        int k=1;
        for (int i=0;i<32;i++){
            if ((n&k)!=0){
                cnt++;
            }
            k<<=1;
        }
        return cnt;
    }

    /**
     * 16.数值的整数次方
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (x==0)
            return 0;
        double res = 1;
        long b=n;
        long len = Math.abs(b);
        long i=1;
        while (i<=len){
            int t=1;
            double temp = x;
            while (i+2*t<len && t<Integer.MAX_VALUE/2){
                temp *= temp;
                t *= 2;
            }
            res *=temp;
            i+=t;
        }

        if (n>=0)
            return res;
        else
            return 1/res;
    }

    /**
     * 16.数值的整数次方 2.0
     * 快速幂 good
     * 时间复杂度：O(logN)
     * 空间复杂度:O(1)
     * @param x
     * @param n
     * @return
     */
    public double myPow_2(double x, int n){
        //x^n可表示为：x^a*x^b..*x^c = x^(a+b+..+c)
        //即：n=a+b+..+c，这与n的二进制位中1的位置一致
        //如：x^15=x^1*x^2*x^4*x^8=x^(1+2+4+8),n=15。15的二进制位：0000 0000 0000 1111,即15=2^0+2^1+2^2+2^3=1+2+4+8
        if (n==0) return 1;
        if (n==1) return x;

        double res = 1;   //结果
        long b=n;   //防止负数转正数溢出
        long absN = Math.abs(b);
        while (absN>0){
            if ((absN & 1)==1){
                res *= x;
            }
            x*=x;
            absN >>= 1;
        }

        return n>0 ? res : 1/res;
    }

    /**
     * 17.打印从1到最大的n位数
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param n
     * @return
     */
    public int[] printNumbers(int n) {
        int base=10;
        int max = (int) (Math.pow(base,n)-1);
        IntStream stream = IntStream.iterate(1,x->x+1).limit(max);
        return stream.toArray();
    }

    /**
     * 18.删除链表的节点
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head==null)
            return null;
        ListNode dummyNode = new ListNode(-val);
        dummyNode.next=head;

        ListNode cursor = dummyNode;
        while (cursor.next !=null){
            if (cursor.next.val==val){
                cursor.next = cursor.next.next;
                return dummyNode.next;
            }
            cursor = cursor.next;
        }
        return dummyNode.next;
    }
}
