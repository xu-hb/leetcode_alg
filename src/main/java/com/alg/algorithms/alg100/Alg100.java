package com.alg.algorithms.alg100;

import com.alg.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Alg100 {
    List<String> ipStrList = new ArrayList<>();
    List<String> tempList = new ArrayList<>();
    int len;
    int minCursor;
    /**
     * 93.复原IP地址
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        len=s.length();
        minCursor = len/4-1;
        dfsPartition(s,0);
        return ipStrList;
    }

    private void dfsPartition(String s , int size){
        if (size==len){
            ipStrList.add(String.join(".",tempList));
            return;
        }
        for (int i=minCursor;i<Math.min(s.length(),4);i++){
            String str = s.substring(0,i+1);
            if (validateIp(str)){
                tempList.add(str);
                String rightStr = s.substring(i+1);
                dfsPartition(rightStr,size+str.length());
                tempList.remove(tempList.size()-1);
            }
        }
    }

    /**
     * 校验是否为合法ip
     * @param str
     * @return
     */
    private boolean validateIp(String str) {
        return Long.parseLong(str)<=255;
    }

    /**
     * 94.二叉树的中序遍历
     * 递归
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
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
        //左节点
        traversal(node.left,list);
        //中节点
        list.add(node.val);
        //右节点
        traversal(node.right , list);
    }
}
