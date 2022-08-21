package com.alg.algorithms.offer.alg100;

import com.alg.common.ListNode;
import com.alg.common.TreeNode;

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
}
