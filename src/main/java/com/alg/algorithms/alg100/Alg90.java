package com.alg.algorithms.alg100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Alg90 {
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    /**
     * 90.子集II
     * todo
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 0){
            result.add(new ArrayList<>());
            return result;
        }
        subsetsHelper(nums, 0);
        return result;
    }

    private void subsetsHelper(int[] nums, int startIndex){
        result.add(new ArrayList<>(list));//「遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合」。
        if (startIndex >= nums.length){ //终止条件可不加
            return;
        }
        for (int i = startIndex; i < nums.length; i++){
            if ( i > startIndex && nums[i - 1] == nums[i] ) {
                continue;
            }
            list.add(nums[i]);
            subsetsHelper(nums, i + 1);
            list.remove(list.size()-1);
        }
    }
}
