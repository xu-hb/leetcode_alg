package com.alg.algorithms.offer.alg50;

import com.alg.common.TreeNode;

import java.util.*;
import java.util.function.IntFunction;

public class Alg40 {
    /**
     * 31.栈的压入,弹出序列
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed==null || popped==null || pushed.length==0 || popped.length==0)
            return true;
        int n = pushed.length;
        int m = popped.length;
        int idxN=0,idxM=0;
        Stack<Integer> stack = new Stack<>();

        while (idxN<n && idxM<m){
            if (popped[idxM]==pushed[idxN]){
                //相等：idxM入栈并出栈
                idxM++;
                idxN++;
            }else {
                //不等
                int val = stack.isEmpty() ? -1 : stack.peek();
                if (val==popped[idxM]){
                    stack.pop();
                    idxM++;
                }else {
                    stack.push(pushed[idxN]);
                    idxN++;
                }
            }
        }

        //对比栈中剩余数据
        while (!stack.isEmpty() && idxM<m){
            if (stack.pop() != popped[idxM++]){
                return false;
            }
        }

        return stack.isEmpty() && idxN>=n && idxM>=m;
    }

    /**
     * 31.栈的压入,弹出序列
     * 代码简化
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences_2(int[] pushed, int[] popped){
        if (pushed==null || popped==null || pushed.length==0 || popped.length==0)
            return true;
        int idxM=0;
        Deque<Integer> deque = new LinkedList<>();
        for (int n : pushed){
            deque.push(n);
            while (idxM<popped.length && !deque.isEmpty() && deque.peek()==popped[idxM]){
                deque.pop();
                idxM++;
            }
        }
        return idxM== popped.length;
    }

    /**
     * 32-I.从上到下打印树
     * BFS
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if (root==null)
            return new int[]{};
        List<Integer> values = new ArrayList<>(1001);
        Queue<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (! deque.isEmpty()){
            TreeNode node = deque.poll();
            values.add(node.val);
            if (node.left !=null)
                deque.add(node.left);
            if (node.right !=null)
                deque.add(node.right);
        }
        int idx=0;
        int[] res = new int[values.size()];
        for (int n : values){
            res[idx]=n;
            idx++;
        }
        return res;
    }

    /**
     * 32-I.从上到下打印树 2.0
     * DFS
     * @param root
     * @return
     */
    public int[] levelOrder_2(TreeNode root){
        if (root==null)
            return new int[]{};
        cnt=0;
        map = new HashMap<>();
        dfs(root,0);
        int idx=0;
        int[] res = new int[cnt];
        for (List<Integer> list : map.values()){
            for (int n : list){
                res[idx++] = n;
            }
        }
        return res;
    }
    Map<Integer,List<Integer>> map;
    //数量
    int cnt;
    private void dfs(TreeNode root , int depth){
        if (root==null)
            return;
        cnt++;
        List<Integer> list = map.getOrDefault(depth,new ArrayList<>());
        list.add(root.val);
        map.put(depth, list);
        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }

    /**
     * 32-II.从上到下打印二叉树II
     * BFS
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_3(TreeNode root) {
        if (root==null)
            return new ArrayList<>();
        cnt=0;
        map = new HashMap<>();
        dfs(root,0);
        return new ArrayList<>(map.values());
    }
}
