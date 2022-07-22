package com.alg.algorithms.alg800;

import java.util.Arrays;
import java.util.Comparator;

public class Alg760 {
    /**
     * 757.设置交集大小至少为2
     * @param intervals
     * @return
     */
    public int intersectionSizeTwo(int[][] intervals) {
        int n = intervals.length;
        int result = 2; //第一个区间结果
        //按区间尾升序
        Arrays.sort(intervals, (o1, o2) -> o1[1]==o2[1] ? o1[0]-o2[0] : o1[1]-o2[1]);

        int lastEnd = intervals[0][1];
        int[] dp = new int[2*n];
        dp[0]=lastEnd-1;
        dp[1]=lastEnd;
        int dpIndex=1;
        //从第二区间开始
        for (int i=1;i<n;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            int temp=0;
            int endGap = lastEnd-start;
            if (endGap==0) {
                temp=1;
                dp[++dpIndex] = end;
            } else if (endGap>0){
                if (start<dp[dpIndex-1] ) temp=0;
                else if (start==dp[dpIndex-1] || start<=dp[dpIndex]) {
                    temp=1;
                    dp[++dpIndex]=end;
                } else {
                    temp=2;
                    dp[++dpIndex]=end-1;
                    dp[++dpIndex]=end;
                }
            }else {
                temp=0;
            }

            if (temp>0){
                result+=temp;
                lastEnd = end;
            }


//            if (lastEnd-1<start){
//                int gap = start-lastEnd;
//                //一个交集+1,无交集+2
//                int temp = 0;
//                if (gap<0) temp=0;
//                else if (gap==0) temp=1;
//                else temp=2;
//
//                result+= temp;
//                lastEnd = end;
//            }
        }
        return result;
    }
}
