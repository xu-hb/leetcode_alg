package com.alg.algorithms.leetcode.alg200;

import com.alg.common.TreeNode;

import java.util.*;

public class Alg110 {
    /**
     * 102.二叉树的层序遍历
     * 递归
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        int deep=0;
        recursion(resList , root , deep);
        return resList;
    }

    /**
     * 递归
     * @param resList
     * @param node
     * @param deep
     */
    private void recursion(List<List<Integer>> resList, TreeNode node, int deep) {
        if (null == node){
            return;
        }
        ++deep;
        if (resList.size()<deep){
            resList.add(new ArrayList<>());
        }
        resList.get(deep-1).add(node.val);
        recursion(resList , node.left , deep);
        recursion(resList , node.right , deep);
    }

    /**
     * 102.二叉树的层序遍历 2
     * 队列
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_2(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (null==root){
            return resList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (! queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            resList.add(list);
            int len = queue.size();
            //遍历同一层级
            while (len>0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (null != node.left) queue.add(node.left);
                if (null != node.right) queue.add(node.right);
                len--;
            }
        }
        return resList;
    }

    /**
     * 104.二叉树的最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root==null)
            return 0;
        //后序遍历
        int depthLeft = maxDepth(root.left);
        int depthRight = maxDepth(root.right);
        return Math.max(depthLeft , depthRight)+1;
    }

    /**
     * 104.二叉树的最大深度 BFS
     * @param root
     * @return
     */
    public int maxDepth_2(TreeNode root) {
        if (root==null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (! queue.isEmpty()){
            int size = queue.size();
            while (size>0){
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right !=null){
                    queue.add(node.right);
                }
                size--;
            }
            depth++;
        }
        return depth;
    }

    /**
     * 105.从前序与中序遍历序列构造二叉树
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return buildTreeByOrder(0,preorder.length-1 , 0 , inorder.length-1);
    }
    //先序遍历
    int[] preorder = null;
    //中序遍历
    int[] inorder = null;

    /**
     * 从先序和中序中构建二叉树
     * @param pStart 先序开始
     * @param pEnd 先序结束
     * @param iStart 中序开始
     * @param iEnd 中序结束
     * @return
     */
    private TreeNode buildTreeByOrder(int pStart, int pEnd , int iStart , int iEnd) {
        if (pStart>pEnd || iStart>iEnd)
            return null;

        //先序遍历的第一个节点为根节点
        int rootVal = preorder[pStart];
        TreeNode root = new TreeNode(rootVal);

        //--1.构建左子树
        //找到左子树的节点：中序遍历结果的根节点之前的值为左子树
        int iStart_1=iStart;
        int iEnd_1=0;
        for (int i=iStart;i<=iEnd;i++){
            iEnd_1=i;
            if (inorder[i] ==rootVal)
                break;
        }
        iEnd_1-=1; //根节点前一个节点为终止节点
        int pStart_1=pStart+1;  //从跟节点下一个开始
        int pEnd_1=pStart_1+(iEnd_1-iStart_1);  //左子树的数量在先序和中序中的数量都是一致的
        //构建左子树
        root.left = buildTreeByOrder(pStart_1,pEnd_1,iStart_1,iEnd_1);
        //--2.构建右子树
        //先序中左子树后一个节点开始就是右子树；中序则是左子树后再去除一个根节点后开始为右子树
        root.right = buildTreeByOrder(pEnd_1+1,pEnd,iEnd_1+1+1,iEnd);

        return root;
    }

    /**
     * 105.从前序与中序遍历序列构造二叉树 2.0
     * map替代for提高效率
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree_2(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        //初始化
        inorderMap = new HashMap<>(inorder.length);
        for (int i=0;i<inorder.length;i++){
            inorderMap.put(inorder[i],i);
        }
        return buildTreeByOrder_2(0,preorder.length-1 , 0 , inorder.length-1);
    }
    //存储中序遍历结果和序列号映射
    Map<Integer,Integer> inorderMap = null;

    private TreeNode buildTreeByOrder_2(int pStart, int pEnd , int iStart , int iEnd) {
        if (pStart>pEnd || iStart>iEnd)
            return null;

        //先序遍历的第一个节点为根节点
        int rootVal = preorder[pStart];
        TreeNode root = new TreeNode(rootVal);

        //--1.构建左子树
        //找到左子树的节点：中序遍历结果的根节点之前的值为左子树
        int iStart_1=iStart;
        //取消for循环，用map替代提高效率
        int iEnd_1 = inorderMap.get(rootVal);
        iEnd_1-=1; //根节点前一个节点为终止节点
        int pStart_1=pStart+1;  //从跟节点下一个开始
        int pEnd_1=pStart_1+(iEnd_1-iStart_1);  //左子树的数量在先序和中序中的数量都是一致的
        //构建左子树
        root.left = buildTreeByOrder_2(pStart_1,pEnd_1,iStart_1,iEnd_1);
        //--2.构建右子树
        //先序中左子树后一个节点开始就是右子树；中序则是左子树后再去除一个根节点后开始为右子树
        root.right = buildTreeByOrder_2(pEnd_1+1,pEnd,iEnd_1+1+1,iEnd);

        return root;
    }

    /**
     * 106.从中序和后序遍历序列构造二叉树
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree_(int[] inorder, int[] postorder) {
        inorderMap = new HashMap<>(inorder.length);
        for (int i=0;i<inorder.length;i++){
            inorderMap.put(inorder[i],i);
        }
        return build(inorder,0,inorder.length-1,
                postorder,0,postorder.length-1);
    }

    /**
     * 从中序和后序中构建二叉树
     * @param inStart 中序开始
     * @param inEnd 中序结束
     * @param postStart 后序开始
     * @param postEnd 后序结束
     * @return
     */
    TreeNode build(int[] inorder, int inStart, int inEnd,
                   int[] postorder, int postStart, int postEnd) {

        if (inStart > inEnd) {
            return null;
        }
        // root 节点对应的值就是后序遍历数组的最后一个元素
        int rootVal = postorder[postEnd];
        // rootVal 在中序遍历数组中的索引
        int index = inorderMap.get(rootVal);
        // 左子树的节点个数
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        // 递归构造左右子树
        root.left = build(inorder, inStart, index - 1,
                postorder, postStart, postStart + leftSize - 1);

        root.right = build(inorder, index + 1, inEnd,
                postorder, postStart + leftSize, postEnd - 1);
        return root;
    }



    /**
     * 107.二叉树的层序遍历two
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (null==root){
            return resList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (! queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            //后来居上
            resList.add(0,list);
            int len = queue.size();
            //遍历同一层级
            while (len>0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (null != node.left) queue.add(node.left);
                if (null != node.right) queue.add(node.right);
                len--;
            }
        }
        return resList;
    }
}
