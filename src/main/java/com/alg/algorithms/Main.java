package com.alg.algorithms;

import com.alg.algorithms.leetcode.Alg300.Alg220;
import com.alg.algorithms.leetcode.alg100.*;
import com.alg.algorithms.leetcode.alg1000.Alg910;
import com.alg.algorithms.leetcode.alg1000.Alg920;
import com.alg.algorithms.leetcode.alg1000.Alg930;
import com.alg.algorithms.leetcode.alg1100.Alg1050;
import com.alg.algorithms.leetcode.alg1200.Alg1150;
import com.alg.algorithms.leetcode.alg1200.Alg1170;
import com.alg.algorithms.leetcode.alg1200.Alg1190;
import com.alg.algorithms.leetcode.alg1400.Alg1340;
import com.alg.algorithms.leetcode.alg1600.Alg1550;
import com.alg.algorithms.leetcode.alg200.Alg110;
import com.alg.algorithms.leetcode.alg200.Alg120;
import com.alg.algorithms.leetcode.alg200.Alg150;
import com.alg.algorithms.leetcode.alg200.Alg160;
import com.alg.algorithms.leetcode.alg400.Alg300;
import com.alg.algorithms.leetcode.alg500.Alg410;
import com.alg.algorithms.leetcode.alg500.Alg440;
import com.alg.algorithms.leetcode.alg500.Alg460;
import com.alg.algorithms.leetcode.alg500.Alg500;
import com.alg.algorithms.leetcode.alg600.Alg550;
import com.alg.algorithms.leetcode.alg600.Alg590;
import com.alg.algorithms.leetcode.alg700.Alg650;
import com.alg.algorithms.leetcode.alg700.Alg660;
import com.alg.algorithms.leetcode.alg700.Alg670;
import com.alg.algorithms.leetcode.alg800.Alg710;
import com.alg.common.Node;
import com.alg.common.TreeNode;
import com.alg.design.cache.LFUCache;
import com.alg.design.cache.LRUCache;
import com.alg.design.dict.WordDictionary;
import com.alg.design.tree.Trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[]args){
//        Alg30 alg30 = new Alg30();
//        Alg40 alg40 = new Alg40();
//        Alg50 alg50 = new Alg50();
        Alg70 alg70 = new Alg70();
//        Alg710 alg710 = new Alg710();
//        Alg910 alg910 = new Alg910();
//        Alg160 alg160 = new Alg160();
//        Alg150 alg150 = new Alg150();
        Alg100 alg100 = new Alg100();
        Alg220 alg220 = new Alg220();
        Alg60 alg60 = new Alg60();
        Alg80 alg80 = new Alg80();
        Alg410 alg410 = new Alg410();
        Alg550 alg550 = new Alg550();
        Alg120 alg120 = new Alg120();
        Alg660 alg660 = new Alg660();
        Alg110 alg110 = new Alg110();
        Alg920 alg920 = new Alg920();
        Alg500 alg500 = new Alg500();
        Alg650 alg650 = new Alg650();
        Alg300 alg300 = new Alg300();
        Alg1150 alg1150 = new Alg1150();
        Alg590 alg590 = new Alg590();
        Alg440 alg440 = new Alg440();
        Alg460 alg460 = new Alg460();
        Alg1190 alg1190 = new Alg1190();
        Alg1340 alg1340 = new Alg1340();
        Alg1050 alg1050 = new Alg1050();
        Alg1550 alg1550 = new Alg1550();
        Alg1170 alg1170 = new Alg1170();
        Alg670 alg670 = new Alg670();
        Alg930 alg930 = new Alg930();
        Alg910 alg910 = new Alg910();

        test_905(alg910);

    }

    public static void test_905(Alg910 alg){
        int[]arr = new int[]{3,1,2,4};
        int[]res = alg.sortArrayByParity(arr);
        System.out.println(Arrays.toString(Arrays.stream(res).toArray()));
    }

    public static void test_922(Alg930 alg){
        int[]arr = new int[]{4,2,5,7};
        int[]res = alg.sortArrayByParityII_2(arr);
        System.out.println(Arrays.toString(Arrays.stream(res).toArray()));
    }

    public static void test_680(Alg670 alg){
        int res = alg.maximumSwap(99901);
        System.out.println(res);
    }

    public static void test_1161(Alg1170 alg){
        String str = "1,7,7,#,#,-8,#,#,0";
        TreeNode root = TreeNode.deserializePre(str);
        int res = alg.maxLevelSum(root);
        System.out.println(res);
    }

    public static void test_1550(Alg1550 alg){
        int[] arr = new int[]{
                2,6,4,1
//                1,2,34,3,4,5,7,23,12
//                1,1,1
//                1,2,1,1
        };
        boolean res = alg.threeConsecutiveOdds_2(arr);
        System.out.println(res);
    }

    public static void test_1046(Alg1050 alg){
        int res  = alg.lastStoneWeight(new int[]{2,7,4,1,8,1});
        System.out.println(res);
    }

    public static void test_1331(Alg1340 alg){
        int[] arr = new int[]{1,1,1};
        int[] res = alg.arrayRankTransform(arr);
        System.out.println(Arrays.toString(Arrays.stream(res).toArray()));
    }

    public static void test_63(Alg70 alg){
        int[][]arr = new int[][]{
                {1}
        };
       int res =  alg.uniquePathsWithObstacles(arr);
       System.out.println(res);
    }

    public static void test_62(Alg70 alg){
        int res = alg.uniquePaths(3,3);
        System.out.println(res);
    }

    public static void test_1184(Alg1190 alg){
        int res = alg.distanceBetweenBusStops(new int[]{1,3,6,10,2} , 0 , 4);
        System.out.println(res);
    }

    public static void test_452(Alg460 alg){
        int[][] arr = new int[][]{
//                {10,16},
//                {2,8},
//                {1,6},
//                {7,12}
                {-2147483646,-2147483645},
                {2147483646,2147483647}
        };
        int res = alg.findMinArrowShots(arr);
        System.out.println(res);
    }

    public static void test_435(Alg440 alg){
        int resutl = alg.eraseOverlapIntervals_2(new int[][]{
                {1,2},
                {2,3},
                {3,4},
                {1,3}
//                {1,2},
//                {1,2},
//                {1,2}
        });
        System.out.println(resutl);
    }

    public static void test_583(Alg590 alg){
        int res = alg.minDistance("leetcode","etco");
        System.out.println(res);
    }

    public static void test_1143(Alg1150 alg){
        int result = alg.longestCommonSubsequence("abcde","ace");
        System.out.println(result);
    }

    public static void test_300(Alg300 alg){
//        int[] arr = new int[]{10,9,2,5,3,7,101,18};
        int[] arr = new int[]{0,1,0,3,2,3};
//        int[] arr = new int[]{7,7,7,7,7};
//        int[] arr = new int[]{4,10,4,3,8,9};
        int result = alg.lengthOfLIS(arr);
        System.out.println(result);
    }

    public static void test_648(Alg650 alg650){
//        String result = alg650.replaceWords(Arrays.asList("cat","bat","rat"),"the cattle was rattled by the battery");
        String result = alg650.replaceWords(Arrays.asList("a","b","c"),
                "aadsfasf absbs bbab cadsfafs");

        System.out.println(result);
    }

    public static void test_211(){
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        boolean res = wordDictionary.search("pad"); // 返回 False
        System.out.println(res);
        res = wordDictionary.search("bad"); // 返回 True
        System.out.println(res);
        res = wordDictionary.search(".ad"); // 返回 True
        System.out.println(res);
        res=wordDictionary.search("b.."); // 返回 True
        System.out.println(res);
    }

    public static void test_208(){
        Trie trie = new Trie();
        trie.insert("apple");
        boolean res = trie.search("apple");   // 返回 True
        System.out.println(res);
        res = trie.search("app");     // 返回 False
        System.out.println(res);
        res = trie.startsWith("app"); // 返回 True
        System.out.println(res);
        trie.insert("app");
        res =trie.search("app");     // 返回 True
        System.out.println(res);
    }

    public static void test_460(){
        LFUCache cache = new LFUCache(1);
        cache.put(2,1);
        System.out.println(cache.get(2));
        cache.put(3,2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }

    public static void test_146(){
        LRUCache cache = new LRUCache(2);
        cache.put(2,1);
        cache.put(1,1);
        cache.put(2,3);
        cache.put(4,1);

        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

    public static void test_493(Alg500 alg){
        int[] res = new int[]{
//                1,3,2,3,1
//                2,4,3,5,1
//                2147483646,2147483646,-2147483646,-2147483646,-2147483646,2147483646
                5,5,-5,-5,-5,5
        };
        int result = alg.reversePairs_2(res);
        System.out.println(result);
    }

    public static void test_912(Alg920 alg){
        int[] result = alg.sortArray(new int[]{5,2,3,1});
        System.out.println(Arrays.toString(result));
    }

    public static void test(){
        Map<String,Integer> map = new HashMap<>();
        map.put("1",1);
        map.put("2",2);

        map.put("3",map.getOrDefault("3",0)+1);
        System.out.println(map.get("3"));
        map.put("3",map.getOrDefault("3",0)+1);
        System.out.println(map.get("3"));
        map.put("3",map.getOrDefault("3",0)+1);
        System.out.println(map.get("3"));
    }

    public static void test_105(Alg110 alg){
//        TreeNode result = alg.buildTree(new int[]{1,2},new int[]{1,2});
        TreeNode result = alg.buildTree_2(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
        System.out.println(result.toString());
    }

    public static void test_654(Alg660 alg){
        TreeNode node = alg.constructMaximumBinaryTree(new int[]{3,2,1});
        System.out.println(node.toString());
    }

    public static void test_114(Alg120 alg){
        TreeNode node = new TreeNode(1);
        TreeNode node1_l = new TreeNode(2);
        TreeNode node1_r = new TreeNode(5);
        node.left = node1_l;
        node.right=node1_r;

        TreeNode node2_l = new TreeNode(3);
        TreeNode node2_r = new TreeNode(4);
        node1_l.left = node2_l;
        node1_l.right=node2_r;

        TreeNode node3_r = new TreeNode(6);
        node1_r.right=node3_r;

        alg.flatten(node);
        System.out.println(node);
    }

    public static void test_116(Alg120 alg){
        Node node = new Node(1);
        Node node1_l = new Node(2);
        Node node1_r = new Node(3);
        node.left = node1_l;
        node.right=node1_r;

        Node node2_l = new Node(4);
        Node node2_r = new Node(5);
        node1_l.left = node2_l;
        node1_l.right=node2_r;


        Node node3_l = new Node(6);
        Node node3_r = new Node(7);
        node1_r.left = node3_l;
        node1_r.right=node3_r;

        Node result = alg.connect(node);
        System.out.println(result.toString());
    }

    public static void test_543(Alg550 alg){
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(3);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        int result = alg.diameterOfBinaryTree(treeNode);
        System.out.println(result);
    }

    public static void test_410(Alg410 alg){
        int result = alg.splitArray(new int[]{7,2,5,10,8} , 2);
//        int result = alg.splitArray(new int[]{1,2,3,4,5} , 2);
//        int result = alg.splitArray(new int[]{1,4,4} , 3);
        System.out.println(result);
    }

    public static void test_055(Alg60 alg){
        boolean res = alg.canJump(new int[]{1,0,1,0});
        System.out.println(res);
    }

    public static void test_093(Alg100 alg){

        List<String> res = alg.restoreIpAddresses("101023");
        System.out.println(Arrays.toString(res.toArray()));
    }

    public static void test_220(Alg220 alg){

        List<List<Integer>> res = alg.combinationSum3(3,9);
        System.out.println(Arrays.toString(res.toArray()));
    }

    public static void test_150(Alg150 alg){
        String[] token = new String[]{
                "2","1","+","3","*"
        };
        int res = alg.evalRPN(token);
        System.out.println(res);
    }

    public static void test_160(Alg160 alg){
        String res = alg.reverseWords("the sky is");
        System.out.println(res);
    }

    public static void test_904(Alg910 alg){
        int res = alg.totalFruit_2(new int[]{3,3,3,1,2,1,1,2,3,3,4});
        System.out.println(res);
    }

    public static void test_069(Alg70 alg){
        int mount = 2147395599;
        int res = alg.mySqrt(mount);
        System.out.println(res);
    }

    public static void test_704(Alg710 alg){
        int res = alg.search(new int[]{-1,0,3,5,9,12} , 2);
        System.out.println(res);
    }

    public static void test_045(Alg50 alg50){
        int res = alg50.jump(new int[]{3,2,2});
        System.out.println(res);
    }

    public static void test_043(Alg50 alg50){
        String res = alg50.multiply("5" , "12");
        System.out.println(res);
    }



    public static void test_034(Alg40 alg){
        int[] arr = new int[]{};
        int[] res = alg.searchRange(arr , 6);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    public static void test_033(Alg40 alg){
        int[] arr = new int[]{4,5,6,7,0,1,2};
        int res = alg.search(arr , 0);
        System.out.println(res);
    }

    public static void test_031(Alg40 alg){
        int[] res = new int[]{3,2,1};
        alg.nextPermutation_2(res);
        System.out.println(Arrays.toString(Arrays.stream(res).toArray()));
    }

    public static void test_028(Alg30 alg30){
        int res = alg30.strStr("aaaa","ll");
        System.out.println(res);
    }

    public static void test_027(Alg30 alg30){
        int res = alg30.removeElement(new int[]{0,1,2,2,3,0,4,2} , 2);
        System.out.println(res);
    }

    public static void test_026(Alg30 alg30){
        int res = alg30.removeDuplicates_2(new int[]{1,1,3});
        System.out.println(res);
    }
}
