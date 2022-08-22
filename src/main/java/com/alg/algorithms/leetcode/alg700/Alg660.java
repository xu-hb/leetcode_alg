package com.alg.algorithms.leetcode.alg700;

import com.alg.common.TreeNode;

import java.util.*;

public class Alg660 {

    Map<String,Integer> count;
    List<TreeNode> result;
    /**
     * 652.寻找重复的子树
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap<>();
        result = new ArrayList<>();
        collect(root);
        return result;
    }
    private String collect(TreeNode node){
        if (node==null) return "#";
        //通过路径形成key，判定是否有相同结构和节点值
        String key = node.val+","+collect(node.left)+","+collect(node.right);
        count.put(key,count.getOrDefault(key,0)+1);
        if (count.get(key)==2){
            //重复的不纳入
            result.add(node);
        }
        return key;
    }

    /**
     * 652.寻找重复的子树 2.0
     * 由于key过长，导致时间复杂度升高，故使用唯一标识做替换
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees_2(TreeNode root) {
        countMap = new HashMap<>();
        result = new ArrayList<>();
        t=1;
        trees = new HashMap<>();
        collect_2(root);
        return result;
    }
    int t;
    Map<String,Integer> trees;
    Map<Integer,Integer> countMap;
    private int collect_2(TreeNode node){
        if (null== node)
            return 0;
        String key = node.val+","+collect_2(node.left)+","+collect_2(node.right);
        //使用uid替换key，缩短长度
        int uid = trees.computeIfAbsent(key,x->t++);
        countMap.put(uid,countMap.getOrDefault(uid,0)+1);
        if (countMap.get(uid)==2){
            result.add(node);
        }
        return uid;
    }

    /**
     * 654.最大二叉树
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums , 0 , nums.length);
    }

    /**
     * 构建二叉树
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start>=end){
            return null;
        }
        //寻找最大值
        int maxVal = nums[start];
        int maxIndex = start;
        for (int i=start;i<end;i++){
            if (nums[i]>maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        TreeNode node = new TreeNode(maxVal);
        //构建左子树
        node.left = buildTree(nums , start , maxIndex);
        //构建右子树
        node.right = buildTree(nums , maxIndex+1 , end);
        return node;
    }

    /**
     * 655.输出二叉树
     * @param root
     * @return
     */
    public List<List<String>> printTree(TreeNode root) {
        //获取高度
        int height = getHeight(root);
        String[][] ans = new String[height][(1 << height) - 1];
        for (String[] arr : ans) {
            Arrays.fill(arr, "");
        }
        List<List<String>> res = new ArrayList<>();
        fill(ans, root, 0, 0, ans[0].length);
        for (String[] arr : ans) {
            res.add(Arrays.asList(arr));
        }
        return res;
    }
    /**
     * 填充数组
     * @param ans  数组
     * @param root 根节点
     * @param i    第几行
     * @param l    左节点
     * @param r    右节点
     */
    private void fill(String[][] ans, TreeNode root, int i, int l, int r) {
        if (root == null) {
            return;
        }
        ans[i][(l + r) / 2] = "" + root.val;
        fill(ans, root.left, i + 1, l, (l + r) / 2);
        fill(ans, root.right, i + 1, (l + r + 1) / 2, r);
    }
    /**
     * 获取树的高度
     * @param root
     * @return
     */
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
