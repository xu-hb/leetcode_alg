package com.alg.algorithms.leetcode.alg1200;

public class Alg1190 {
    /**
     * 1184.公交站间的距离
     * @param distance
     * @param start
     * @param destination
     * @return
     */
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n = distance.length;
        int temp = start;
        start = Math.min(temp , destination);
        destination = Math.max(temp,destination);

        int rightVal = 0;
        int leftVal = 0;
        for (int i=start;i<destination;i++){
            rightVal+=distance[i];
        }
        for (int j=0;j<n-(destination-start);j++){
            int k = (destination+j)%n;
            leftVal+=distance[k];
            if (leftVal>=rightVal){
                return rightVal;
            }
        }
        return leftVal;
    }
}
