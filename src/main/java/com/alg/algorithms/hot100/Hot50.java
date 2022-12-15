package com.alg.algorithms.hot100;

import com.alg.common.ListNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Hot50 {
    /**
     * 1.两数之和
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        for (int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(target-nums[i]) && i != map.get(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
        }
        return null;
    }

    /**
     * 2.两数相加
     * 时间复杂度：O(Max(l1.length,l2.length))
     * 空间复杂度：O(1)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        int highIndex = 0;  //进位
        while (l1 !=null || l2!=null){
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum = n1 + n2 + highIndex;

            highIndex = sum / 10;
            cur.next = new ListNode(sum % 10);;
            cur=cur.next;

            if (l1 !=null) l1=l1.next;
            if (l2 !=null) l2=l2.next;
        }

        if(highIndex !=0){
            cur.next = new ListNode(highIndex);;
        }
        return dummyHead.next;
    }

    /**
     * 3.无重复字符的最大子串
     * 滑动窗口
     * 时间复杂度：O(N)
     * 空间复杂度：O(C)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int[] window = new int[128];
        Arrays.fill(window,-1);
        int max = 0;
        int low=0,high=0;
        while(high<s.length()){
            char c = s.charAt(high);
            if(window[c] ==-1){
                window[c]=high;
            }else{
                //出现重复,重置重复子窗口
                for(int i=low;i<window[c];i++){
                    window[s.charAt(i)]=-1;
                }
                low=window[c]+1;
                window[c]=high;
            }
            max = Math.max(max, high-low+1);
            high++;
        }
        return max;
    }


}
