package com.alg.algorithms.offer.alg50;

import com.alg.common.ListNode;
import com.alg.common.TreeNode;
import com.alg.design.queue.CQueue;

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

    /**
     * 7.重建二叉树
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder==null)
            return null;

        this.preorder = preorder;
        this.inorder = inorder;
        //存储中序val-idx
        inMap = new HashMap<>(inorder.length);
        for (int i=0;i<inorder.length;i++){
            inMap.put(inorder[i], i);
        }

        return build(0,preorder.length-1,0,inorder.length-1);
    }
    Map<Integer,Integer> inMap;
    int[] preorder;
    int[] inorder;

    private TreeNode build(int pStart,int pEnd,int iStart,int iEnd){
        if (pStart>pEnd || iStart>iEnd){
            return null;
        }

        //根节点
        int rootVal = preorder[pStart];
        TreeNode root = new TreeNode(rootVal);

        int iIdx = inMap.get(rootVal);
        int size = (iIdx-1)-iStart;

        int pStart_1=pStart+1;
        int pEnd_1=pStart_1+size;
        int iStart_1=iStart;
        int iEnd_1=iIdx-1;
        //1.构建左子树--
        root.left = build(pStart_1,pEnd_1,iStart_1,iEnd_1);
        //2.构建右子树--
        root.right = build(pEnd_1+1,pEnd,iIdx+1,iEnd);

        return root;
    }

    /**
     * 9.用两个栈实现队列
     * @see CQueue
     * @return
     */
    private CQueue cQueue(){
        CQueue queue = new CQueue();
        queue.appendTail(5);
        queue.deleteHead();
        queue.deleteHead();
        return queue;
    }

    /**
     * 10.斐波那契数列
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n<2){
            return n;
        }
        int f0=0,f1=1;
        for (int i=2;i<=n;i++){
            int fn = (f0+f1)%1000000007;
            f0 = f1;
            f1 = fn;
        }
        return f1;
    }
}
