package com.alg.algorithms.offer.alg100;

import com.alg.common.ListNode;
import com.alg.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Alg60 {
    /**
     * 52.两个链表的第一个公共节点
     * 时间复杂度：O(Max(M,N))
     * 空间复杂度：O(1)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null || headB==null) return null;
        int lenA=0,lenB=0;
        ListNode curA = headA,curB=headB;
        while (curA !=null){
            lenA++;
            curA=curA.next;
        }
        while (curB !=null){
            lenB++;
            curB=curB.next;
        }
        curA = headA;
        curB=headB;
        while (lenA>lenB){
            curA = curA.next;
            lenA--;
        }
        while (lenB>lenA){
            curB = curB.next;
            lenB--;
        }

        while (lenA>0){
            if (curA==curB){
                return curA;
            }
            curA=curA.next;
            curB=curB.next;
            lenA--;
        }
        return null;
    }

    /**
     * 52.两个链表的第一个公共节点 2.0
     * 代码简化
     * 时间复杂度：O(n+m)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode_2(ListNode headA, ListNode headB){
        if (null==headA || null==headB) return null;

        ListNode curA = headA,curB=headB;
        while (curA !=curB){
            curA = curA==null ? headB : curA.next;
            curB = curB==null ? headA : curB.next;
        }
        return curA;
    }

    /**
     * 53-I.在排序数组中查找数字 I
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (null==nums || nums.length==0) return 0;
        int cnt = 0;

        int l=0,r=nums.length-1;
        //左边界
        while (l<=r){
            int middle = l + (r-l)/2;
            if (target>nums[middle]){
                l=middle+1;
            }else if (target<nums[middle]){
                r=middle-1;
            }else {
                r=middle-1;
            }
        }
        while (l< nums.length && nums[l]==target){
            cnt++;
            l++;
        }
        return cnt;
    }

    /**
     * 53-II.0~n-1中缺失的数字
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int l =0,r=nums.length-1;
        while (l<=r){
            int mid = l+(r-l)/2;
            if (mid==nums[mid]){
                l=mid+1;
            }else if (mid<nums[mid]){
                r=mid-1;
            }
        }
        return l;
    }

    /**
     * 54.二叉搜索树的第K大节点
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        if (k==0) return root.val;
        ans=0;
        cnt=0;
        dfs(root,k);
        return ans;
    }
    int ans,cnt;
    private void dfs(TreeNode root, int k) {
        if (root==null || ans !=0) return;

        dfs(root.right,k);
        if (++cnt==k){
            ans=root.val;
            return;
        }
        dfs(root.left,k);
    }

    /**
     * 54.二叉搜索树的第K大节点 2.0
     * 递减
     * @param root
     * @param k
     * @return
     */
    public int kthLargest_2(TreeNode root, int k) {
        if (root==null) return 0;
        ans=0;cnt=k;
        dfs_2(root);
        return ans;
    }
    private void dfs_2(TreeNode root){
        if (root==null) return;

        //二叉搜索树的中序遍历是递增数列
        //中序的逆序即为递减序列：右、中、左
        dfs_2(root.right);
        if (cnt==0) return;
        if (--cnt==0) {
            ans=root.val;
            return;
        }
        dfs_2(root.left);
    }

    /**
     * 55-I.二叉树的深度
     * BFS
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (! queue.isEmpty()){
            int size = queue.size();
            for (int i=1;i<=size;i++){
                TreeNode node = queue.poll();
                if (node.left !=null) queue.add(node.left);
                if (node.right !=null) queue.add(node.right);
            }
            depth++;
        }
        return depth;
    }

    /**
     * 55-II.平衡二叉树
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;
        depth(root);
        return flag;
    }
    boolean flag=true;
    private int depth(TreeNode root){
        if (root==null || !flag) return 0;
        int l = depth(root.left);
        if (!flag) return 0;
        int r = depth(root.right);
        if (!flag) return 0;
        flag &= Math.abs(r-l)<=1;
        return Math.max(r,l)+1;
    }

    /**
     * 55-II.平衡二叉树 2.0
     * 代码优化
     * @param root
     * @return
     */
    public boolean isBalanced_2(TreeNode root){
        if (root==null) return true;
        return getDepth(root) !=-1;
    }

    /**
     * 获取深度，使用-1统一标识错误和结果
     * @param root
     * @return
     */
    private int getDepth(TreeNode root){
        if (root==null) return 0;
        int l = getDepth(root.left);
        if (l==-1) return -1;
        int r = getDepth(root.right);
        if (r==-1) return -1;
        return Math.abs(r-l)>1 ? -1 : Math.max(r,l)+1;
    }

    /**
     * 56-I.数组中数字出现的次数
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        int r = 0;
        for (int n : nums){
            //异或：相同的两个值异或结果为0
            r = r^n;
        }
        //根据异或特性：不同的位异或=1，将数组分为两组
        //任意一个1均可，这里找最后一个1
        //n&n-1为去掉最后一个1，相减结果则为最后一个1
        int base = r - (r&(r-1));

        int a=0,b=0;
        for (int n: nums){
            //分组分别异或
            if ((n&base)==0){
                a^=n;
            }else {
                b^=n;
            }
        }
        return new int[]{a,b};
    }

    /**
     * 57.和为s的两个数字
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while(i < j) {
            int s = nums[i] + nums[j];
            if(s < target) i++;
            else if(s > target) j--;
            else return new int[] { nums[i], nums[j] };
        }
        return new int[0];
    }

    /**
     * 58-I.翻转单词的顺序
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String[] strs = s.trim().split(" "); // 删除首尾空格，分割字符串
        StringBuilder res = new StringBuilder();
        for(int i = strs.length - 1; i >= 0; i--) { // 倒序遍历单词列表
            if(strs[i].equals("")) continue; // 遇到空单词则跳过
            res.append(strs[i] + " "); // 将单词拼接至 StringBuilder
        }
        return res.toString().trim(); // 转化为字符串，删除尾部空格，并返回
    }
}
