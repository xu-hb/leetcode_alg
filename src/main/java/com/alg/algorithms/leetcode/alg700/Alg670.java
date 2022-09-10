package com.alg.algorithms.leetcode.alg700;

import com.alg.common.TreeNode;

import java.util.*;

public class Alg670 {
    /**
     * 662.二叉树最大宽度
     * BFS
     * 时间复杂度：O(N)
     * 空间复杂度：O(logN)
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        Deque<BiNode> deque = new LinkedList<>();
        deque.addLast(new BiNode(root,1));
        int max = 1;
        while (! deque.isEmpty()){
            int size = deque.size();
            if (size>1){
                max = Math.max(max , deque.getLast().idx - deque.getFirst().idx +1);
            }
            while (size-- >0){
                BiNode node = deque.pollFirst();
                if (node.node.left !=null) deque.addLast(new BiNode(node.node.left,2*node.idx));
                if (node.node.right !=null) deque.addLast(new BiNode(node.node.right,2*node.idx +1));
            }
        }
        return max;
    }

    class BiNode{
        TreeNode node;
        int idx;

        public BiNode(TreeNode node,int idx){
            this.node=node;
            this.idx=idx;
        }
    }

    /**
     * 662.二叉树最大宽度
     * DFS
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param root
     * @return
     */
    public int widthOfBinaryTree_2(TreeNode root){
        map = new HashMap<>();
        dfs(root,1,0);
        return ret;
    }
    int ret;
    Map<Integer,Integer> map;
    private void dfs(TreeNode node,int n,int depth){
        if (node==null) return;
        if (! map.containsKey(depth)) map.put(depth,n);
        ret = Math.max(ret,n-map.get(depth) +1);

        dfs(node.left,n<<1 , depth+1);
        dfs(node.right, n<<1|1 , depth+1);
    }

    /**
     * 667.优美的排列II
     * @param n
     * @param k
     * @return
     */
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int t = n - k - 1;
        for (int i = 0; i < t; i++) ans[i] = i + 1;
        for (int i = t, a = n - k, b = n; i < n; ) {
            ans[i++] = a++;
            if (i < n) ans[i++] = b--;
        }
        return ans;
    }

    /**
     * 669.修剪二叉搜索树
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param root
     * @param low
     * @param high
     * @return
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root==null)
            return null;

        if (root.val< low)
            return trimBST(root.right,low,high);
        if (root.val > high)
            return trimBST(root.left,low,high);

        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right,low,high);
        return root;
    }

    /**
     * 670.最大交换
     * @param num
     * @return
     */
    public int maximumSwap(int num) {
        char[] origin = String.valueOf(num).toCharArray();
        char[] sorted = String.valueOf(num).toCharArray();
        int n = sorted.length;
        Arrays.sort(sorted);
        int i=0,j=n-1;
        for (;i<n;i++,j--){
            if (origin[i] !=sorted[j]){
                break;
            }
        }
        if (i<n){
            char temp = origin[i];
            origin[i]=sorted[j];
            for (int k=n-1;k>=0;k--){
                if (origin[k]==sorted[j]){
                    origin[k]=temp;
                    break;
                }
            }
        }
        return Integer.parseInt(String.valueOf(origin));
    }
}
