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
}
