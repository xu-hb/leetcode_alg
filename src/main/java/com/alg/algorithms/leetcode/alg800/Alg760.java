package com.alg.algorithms.leetcode.alg800;

import java.util.Arrays;

public class Alg760 {
    /**
     * 757.设置交集大小至少为2
     * @param intervals
     * @return
     */
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int pre1=intervals[0][1]-1,pre2=intervals[0][1],ans=2;
        for(int i=1;i<intervals.length;i++){
            //始终保持pre1<pre2
            if(pre1>=intervals[i][0]&&pre2<=intervals[i][1]){continue;}//两个数都在范围内
            else if(pre2<intervals[i][0]){
                //两个数都不在范围内
                ans+=2;
                pre1=intervals[i][1]-1;
                pre2=intervals[i][1];
            }
            else if(pre1<intervals[i][0]){
                ans++;
                if(pre2==intervals[i][1]){pre1=pre2-1;}
                else{
                    pre1=pre2;
                    pre2=intervals[i][1];
                }
            }
        }
        return ans;
    }
}
