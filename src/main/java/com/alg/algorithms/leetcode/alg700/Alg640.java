package com.alg.algorithms.leetcode.alg700;

import com.alg.common.TreeNode;

import java.util.*;

public class Alg640 {
    /**
     * 632.在二叉树中增加一行
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param root
     * @param val
     * @param depth
     * @return
     */
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        //虚拟节点
        TreeNode dummyNode = new TreeNode(-1);
        dummyNode.left=root;
        //结束节点
        TreeNode endNode = new TreeNode(-1);
        //栈
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node;
        queue.add(dummyNode);
        queue.add(endNode);

        while (! queue.isEmpty()){
            if (depth==1){
                break;
            }
            node = queue.poll();
            if (node==endNode){
                --depth;
                //未到指定深度
                queue.add(endNode);
            }else {
                if (node.left !=null) queue.add(node.left);
                if (node.right !=null) queue.add(node.right);
            }
        }

        //此时达到指定深度的父级
        while (! queue.isEmpty()){
            TreeNode curNode = queue.poll();
            if (null !=curNode && curNode!=endNode){
                //左子树
                TreeNode leftNode = new TreeNode(val);
                leftNode.left = curNode.left;
                curNode.left=leftNode;
                //右子树
                TreeNode rightNode = new TreeNode(val);
                rightNode.right = curNode.right;
                curNode.right=rightNode;
            }
        }
        return dummyNode.left;
    }

    /**
     * 632.在二叉树中增加一行 2.0
     * BFS：优化
     * @param root
     * @param val
     * @param depth
     * @return
     */
    public TreeNode addOneRow_2(TreeNode root, int val, int depth){
        if (depth==1){
            return new TreeNode(val , root , null);
        }

        List<TreeNode> list = new LinkedList<>();
        list.add(root);
        for (int i=1;i<depth-1;i++){
            List<TreeNode> sunNodes = new LinkedList<>();
            for (TreeNode node : list){
                if (node.left !=null) sunNodes.add(node.left);
                if (node.right !=null) sunNodes.add(node.right);
                list = sunNodes;
            }
        }

        for (TreeNode node : list){
            node.left = new TreeNode(val , node.left ,null);
            node.right = new TreeNode(val , null, node.right);
        }

        return root;
    }

    /**
     * 632.在二叉树中增加一行 3.0
     * DFS
     * @param root
     * @param val
     * @param depth
     * @return
     */
    public TreeNode addOneRow_3(TreeNode root, int val, int depth){
        if (depth==1){
            return new TreeNode(val , root , null);
        }
        this.val = val;
        this.depth = depth;
        dfs(root,1);
        return root;
    }
    private int val,depth;
    private void dfs(TreeNode root , int d) {
        if (root==null) return;
        if (d==depth-1){
            root.left = new TreeNode(val , root.left , null);
            root.right = new TreeNode(val , null , root.right);
        }
        dfs(root.left,d+1);
        dfs(root.right,d+1);
    }

    /**
     * 636.函数的独占时间
     * @param n
     * @param logs
     * @return
     */
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<int[]> stack = new ArrayDeque<int[]>(); // {idx, 开始运行的时间}
        int[] res = new int[n];
        for (String log : logs) {
            int idx = Integer.parseInt(log.substring(0, log.indexOf(':')));
            String type = log.substring(log.indexOf(':') + 1, log.lastIndexOf(':'));
            int timestamp = Integer.parseInt(log.substring(log.lastIndexOf(':') + 1));
            if ("start".equals(type)) {
                if (!stack.isEmpty()) {
                    res[stack.peek()[0]] += timestamp - stack.peek()[1];
                    stack.peek()[1] = timestamp;
                }
                stack.push(new int[]{idx, timestamp});
            } else {
                int[] t = stack.pop();
                res[t[0]] += timestamp - t[1] + 1;
                if (!stack.isEmpty()) {
                    stack.peek()[1] = timestamp + 1;
                }
            }
        }
        return res;
    }

    /**
     * 640.求解方程
     * @param equation
     * @return
     */
    public String solveEquation(String equation) {
        char defSym = '+';
        char var = 'x';

        //最开始和'='的后一位增加符合位：len+2
        char[] arr = new char[equation.length()+2];
        int idx=0;
        //初始化
        for (int i=0;i<equation.length();i++,idx++){
            char c = equation.charAt(i);
            if (i==0 && c!='+' && c!='-'){
                arr[idx]=defSym;
                ++idx;
                arr[idx] = c;
            }else if (c=='=' && equation.charAt(i+1) !='+' && equation.charAt(i+1) !='-'){
                arr[idx] = c;
                arr[++idx] = defSym;
            }else {
                arr[idx] = c;
            }
        }

        int leftFlag = -1;   //左侧倍数
        int v = 0;  //数值
        int leftVal = 0,rightVal=0;
        boolean varFlag=false;
        int times=1;

        for (int i=arr.length-1;i>=0;i--){
            if (arr[i]=='='){
                //到达左侧
                leftFlag = 1;
                continue;
            }
            //1.符号
            if (arr[i]=='+' || arr[i]=='-'){
                int tep = transferVar(arr[i]);
                //兼容数值1x写为x的情况
                int val = v==0 ? 1 : v;
                if (varFlag){
                    //计算左侧变量
                    leftVal += tep * leftFlag * val;
                }else {
                    //计算右侧值
                    rightVal += -1 * tep * leftFlag * val;
                }
                varFlag=false;
                times=1;
                v=0;
            }
            //2.常数
            if (arr[i]>='0' && arr[i]<='9'){
                v+=(arr[i]-'0')*times;
                times*=10;
            }
            //3.变量
            if (arr[i]==var){
                varFlag=true;
            }
        }

        //对比结果
        if (leftVal==0 && rightVal==0)
            //无限解
            return "Infinite solutions";

        if (leftVal==0 && rightVal !=0)
            //无解
            return "No solution";

        //只有一个解
        int temp = rightVal / leftVal;
        return "x="+temp;
    }

    /**
     * 运算符转换
     * @param c
     * @return
     */
    private int transferVar(char c){
        return c=='+' ? 1 : -1;
    }
}
