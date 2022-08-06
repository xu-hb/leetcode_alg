package com.alg.algorithms.offer.alg50;

import com.alg.common.ListNode;

import java.util.*;

/**
 * 剑指offer2：1-10题
 */
public class Alg10 {
    /**
     * 3.数组中重复的数字
     * 时间复杂度：O(NlogN)
     * 空间复杂度：O(logN)
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i=1;i<nums.length;i++){
            if (nums[i]==nums[i-1])
                return nums[i];
        }
        return -1;
    }

    /**
     * 3.数组中重复的数字 2.0
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param nums
     * @return
     */
    public int findRepeatNumber_2(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i=0;i<nums.length;i++){
            if (set.contains(nums[i]))
                return nums[i];
            set.add(nums[i]);
        }
        return -1;
    }

    /**
     * 3.数组中重复的数字 3.0
     * 值作为索引
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param nums
     * @return
     */
    public int findRepeatNumber_3(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i=0;i<nums.length;i++){
            arr[nums[i]]+=1;
        }
        for (int i=0;i<nums.length;i++){
            if (arr[i]>1) return i;
        }
        return -1;
    }

    /**
     * 3.数组中重复的数字 4.0
     * 原数组上 值与索引互调
     * 时间复杂度：O(N)
     * 空间复杂度:O(1)
     * @param nums
     * @return
     */
    public int findRepeatNumber_4(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if(nums[i] == i) {
                i++;
                continue;
            }
            if(nums[nums[i]] == nums[i]) return nums[i];
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }

    /**
     * 4.二维数组中的查找
     * 时间复杂度:O(n+m)
     * 空间复杂度：O(1)
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
        if (n==0) return false;
        int m = matrix[0].length;
        int i=0,j=m-1;
        //旋转45°，转换成平衡二叉树
        while (i<n && j>=0){
            if (matrix[i][j]==target) return true;
            if (matrix[i][j]<target){
                i++;
            }else {
                j--;
            }
        }
        return false;
    }

    /**
     * 5.替换空格
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)==' ')
                sb.append("%20");
            else
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    /**
     * 6.从尾到头打印链表
     * 栈：不改变链表
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur !=null){
            stack.push(cur.val);
            cur = cur.next;
        }
        int[] val = new int[stack.size()];
        int idx=0;
        while (! stack.isEmpty()){
            val[idx++] = stack.pop();
        }
        return val;
    }

    /**
     * 6.从尾到头打印链表 2.0
     * 链表反转
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param head
     * @return
     */
    public int[] reversePrint_2(ListNode head) {
        int count = 0;
        ListNode pre = null,cur = head;
        while (cur !=null){
            count++;
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        int idx = 0;
        int[] res = new int[count];
        while (pre !=null){
            res[idx++] = pre.val;
            pre = pre.next;
        }

        return res;
    }
}
