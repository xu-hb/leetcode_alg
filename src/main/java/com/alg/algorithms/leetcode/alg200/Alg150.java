package com.alg.algorithms.leetcode.alg200;

import com.alg.common.TreeNode;
import com.alg.design.LRUCache;

import java.util.*;

public class Alg150 {
    /**
     * 144.二叉树的前序遍历
     * 递归
     * 时间复杂度：O(N)
     * 空间复杂度：O(N) 递归栈深度N
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if(Objects.isNull(root)){
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        //递归遍历
        traversal(root , list);
        return list;
    }

    //递归遍历
    public void traversal(TreeNode node, List<Integer> list) {
        if (node==null) return;
        //中节点
        list.add(node.val);
        //左节点
        traversal(node.left,list);
        //右节点
        traversal(node.right , list);
    }

    /**
     * 144.二叉树的前序遍历 2
     * 迭代，本质上合递归一样，不过将栈置于明处
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal_2(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        TreeNode node = root;
        //栈
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || node!=null){
            while (node !=null){
                result.add(node.val);
                stack.push(node);
                node=node.left;
            }
            node=stack.pop().right;
        }
        return result;
    }

    /**
     * 145.二叉树的后序遍历
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if(Objects.isNull(root)){
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        //递归遍历
        posTraversal(root , list);
        return list;
    }

    /**
     * 146.LRU缓存
     * @see LRUCache
     * @param capacity
     */
    public void LRUCache(int capacity){
        cache = new LRUCache(capacity);
    }
    public int get(int key){
        return cache.get(key);
    }
    public void put(int key , int val){
        cache.put(key , val);
    }
    private LRUCache cache = null;

    /**
     * 146.LRU缓存 2.0
     * 自定义实现
     * @param capacity
     */
    public void LRUCache_2(int capacity){
        com.alg.design.cache.LRUCache cache = new com.alg.design.cache.LRUCache(capacity);
    }


    /**
     * 150.逆波兰表达式求值
     * 栈
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (String str : tokens){
            switch (str){
                case "+" : deque.push(deque.pop()+deque.pop());
                    break;
                case "-" :
                    int temp1 = deque.pop();
                    int temp2 = deque.pop();
                    deque.push(temp2-temp1);
                    break;
                case "*" : deque.push(deque.pop()*deque.pop());break;
                case "/" :
                    int temp3 = deque.pop();
                    int temp4 = deque.pop();
                    deque.push(temp4/temp3);
                    break;
                default:
                    deque.push(Integer.valueOf(str));
            }
        }
        return deque.pop();
    }

    /**
     * 后序遍历
     * @param node
     * @param list
     */
    public void posTraversal(TreeNode node, List<Integer> list) {
        if (node==null) return;
        //左节点
        posTraversal(node.left,list);
        posTraversal(node.right , list);
        list.add(node.val);
    }
}
