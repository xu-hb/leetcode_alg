package com.alg.algorithms.offer.alg100;

import com.alg.common.TreeNode;

import java.util.ArrayList;

public class Alg70 {

    /**
     * 61.扑克牌中的顺子
     * 时间复杂度：O(N)
     * 空间复杂度：O(C)
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        int[] repeat = new int[14];
        int max=0,min=16;
        for (int n : nums){
            if (n==0) {
                continue;
            }
            max = Math.max(max,n);
            min = Math.min(min,n);
            if (repeat[n]!=0)
                return false;
            repeat[n]++;
        }
        return max-min<5;
    }

    /**
     * 62.圆圈中最后的数字
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

    /**
     * 63.股票的最大利润
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices)  {
        if(prices == null || prices.length <= 1) {
            return 0;
        }
        int[]dp=new int[prices.length];
        dp[0]=0;
        int min=prices[0];
        for (int i=1;i<prices.length;i++){
            if (prices[i]<=min){
                min = prices[i];
            }
            dp[i]=Math.max(dp[i-1],prices[i]-min);
        }
        return dp[prices.length-1];
    }

    /**
     * 64.求1+2+3+...+n
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param n
     * @return
     */
    public int sumNums(int n) {
        //等差求和：sn=(a1+an)*n/2
        int base = 1+n;
        return sumNums(base,n)>>1;
    }
    private int sumNums(int num , int cnt){
        int sum=0;
        //利用短路特性，实现if效果
        boolean flag = cnt>0 && (sum+=num+sumNums(num,cnt-1))>0;
        return sum;
    }

    /**
     * 65.不用加减乘除做加法
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        while (b!=0){
            //进位
            int c = a & b;
            //非进位
            a ^= b;
            //进位左移一位
            b = c<<1;
        }
        return a;
    }

    /**
     * 68-I.二叉搜索树的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        min = Math.min(pVal,qVal);
        max = Math.max(pVal,qVal);
        return search(root);
    }
    int min = 0;
    int max = 0;
    private TreeNode search(TreeNode root){
        while (root !=null){
            if (root.val>=min && root.val<=max){
                return root;
            }else if (max<= root.val){
                return search(root.left);
            }else if (min>= root.val){
                return search(root.right);
            }
        }
        return null;
    }

    /**
     * 68-I.二叉搜索树的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor_3(TreeNode root, TreeNode p, TreeNode q){
        if (root==null) return null;

        if (root.val<p.val && root.val<q.val){
            return lowestCommonAncestor_3(root.right,p,q);
        }else if (root.val>p.val && root.val>q.val){
            return lowestCommonAncestor_3(root.left,p,q);
        }else {
            //p,q在两侧，当前节点则为祖先节点
            return root;
        }
    }

    /**
     * 68-II.二叉树的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q) {
        location(root,p.val,q.val);
        return ret;
    }
    TreeNode ret;
    private boolean location(TreeNode root , int pVal , int qVal){
        if (root==null) return false;
        //左子树
        boolean lFlag = location(root.left,pVal,qVal);
        //右子树
        boolean rFlag = location(root.right,pVal,qVal);
        //根节点
        boolean rootFlag = root.val==pVal || root.val==qVal;

        if (lFlag&&rFlag || rootFlag && (lFlag || rFlag)){
            ret = root;
        }
        return lFlag || rFlag || rootFlag;
    }
}
