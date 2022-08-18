package com.alg.algorithms.offer.alg50;

import com.alg.common.TreeNode;
import com.alg.design.list.MyList;

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

    /**
     * 32-III.从上到下打印二叉树III
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_4(TreeNode root) {
        if (root==null)
            return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        recursion(list,root,0);
        return list;
    }

    private void recursion(List<List<Integer>> list, TreeNode root, int depth) {
        if (root==null)
            return;
        ++depth;
        List<Integer> line;
        if (list.size()<depth){
            line = new LinkedList<>();
            list.add(line);
        }else {
            line = list.get(depth-1);
        }
        if ((depth&1)==1){
            line.add(root.val);
        }else {
            //偶数行，逆序
            line.add(0, root.val);
        }

        recursion(list,root.left,depth);
        recursion(list,root.right,depth);
    }

    /**
     * 34.二叉树中和为某一值得路径
     * @param root
     * @param target
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList<>();
        pathSum(root,new ArrayList<Integer>(),target);
        return res;
    }

    List<List<Integer>> res;

    private void pathSum(TreeNode root, ArrayList<Integer> integers, int target) {
        if (root==null){
            return;
        }
        integers.add(root.val);
        target-=root.val;

        if (root.left==null && root.right==null){
            //叶子节点
            if (target==0){
                res.add(new ArrayList<>(integers));
            }
            return;
        }

        if (root.left !=null){
            pathSum(root.left,integers,target);
            integers.remove(integers.size()-1);
        }
        if (root.right !=null){
            pathSum(root.right,integers,target);
            integers.remove(integers.size()-1);
        }
    }

    //2.0：代码简化
    private void pathSum_2(TreeNode root, ArrayList<Integer> integers, int target) {
        if (root==null){
            return;
        }
        integers.add(root.val);
        target-=root.val;

        if (root.left==null && root.right==null && target==0){
            res.add(new ArrayList<>(integers));
        }
        pathSum(root.left,integers,target);
        pathSum(root.right,integers,target);
        integers.remove(integers.size()-1);
    }

    /**
     * 35.复杂链表的复制
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head==null)
            return null;
        Node dummyNode = new Node(-1);
        Node curRoot = dummyNode;
        Node curHead = head;
        Map<Node,Node> map = new HashMap<>();
        while (curHead !=null){
            Node newNode = copy(curHead);
            map.put(curHead,newNode);
            curRoot.next=newNode;
            curHead=curHead.next;
            curRoot=curRoot.next;
        }
        curRoot = dummyNode.next;
        curHead = head;
        while (curRoot !=null){
            curRoot.random = curHead.random==null ? null : map.getOrDefault(curHead.random,null);
            curHead=curHead.next;
            curRoot=curRoot.next;
        }
        return dummyNode.next;
    }
    private Node copy(Node node){
        return new Node(node.val);
    }


    /**
     * 35.复杂链表的复制 2.0
     * 代码简化
     * @param head
     * @return
     */
    public Node copyRandomList_2(Node head){
        Map<Node,Node> map = new HashMap<>();
        Node cur = head;
        while (cur!=null){
            map.put(cur , new Node(cur.val));
            cur = cur.next;
        }
        cur=head;
        while (cur !=null){
            map.get(cur).next=map.get(cur.next);
            map.get(cur).random=map.get(cur.random);
            cur=cur.next;
        }
        return map.get(head);
    }

    /**
     * 35.复杂链表的复制 3.0
     * 不使用辅助空间
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param head
     * @return
     */
    public Node copyRandomList_3(Node head){
        if (head==null)
            return null;

        Node cur = head;
        //链表节点复制
        while (cur !=null){
            //克隆节点插入到原节点后
            Node clone = new Node(cur.val);
            clone.next=cur.next;
            cur.next=clone;
            cur=clone.next;
        }
        //随机指针复制
        cur=head;
        while (cur!=null){
            if (cur.random !=null){
                cur.next.random=cur.random.next;
            }
            cur=cur.next.next;
        }
        //分离原链表和克隆链表
        Node root = head.next;
        cur=head;
        Node copy = root;
        while (cur !=null){
            cur.next=cur.next.next;
            cur = cur.next;
            if (copy.next !=null){
                copy.next=copy.next.next;
                copy = copy.next;
            }
        }
        return root;
    }

    /**
     * 36.二叉搜索树与双向链表
     * @see MyList
     * @param root
     * @return
     */
    public MyList.Node treeToDoublyList(MyList.Node root) {
        return new MyList().treeToDoublyList(root);
    }

    /**
     * 39.数组中出现次数超过一半的数字
     * 时间复杂度：O(NlogN)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     * 39.数组中出现次数超过一半的数字 2.0
     * 消除
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int majorityElement_2(int[] nums) {
        int l=0,r=nums.length-1;
        int cnt=0;
        //消除：两个不同的数消除，最后剩下的则是结果
        while (l<r){
            if (nums[l]==nums[r]){
                cnt++;
            }else {
                if (cnt>0){
                    cnt--;
                }else {
                    l++;
                }
            }
            r--;
        }
        return nums[l];
    }

    /**
     * 40.最小的k个数
     * 计数排序
     * 时间复杂度：O(N)
     * 空间复杂度：O(M)
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] sorted = new int[10001];
        for (int n :arr){
            sorted[n]++;
        }
        int[] res = new int[k];
        int idx=0;
        for (int i=0;i< sorted.length && idx<k;i++){
            while (sorted[i]>0 && idx<k){
                res[idx++] = i;
                sorted[i]--;
            }
        }
        return res;
    }

    /**
     * 40.最小的k个数 2.0
     * 堆排序
     * 时间复杂度：NlogK
     * 空间复杂度：O(k)
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers_2(int[] arr, int k){
        if (k==0 || arr.length==0){
            return new int[0];
        }
        //默认小根堆，修改为大根堆
        Queue<Integer> queue = new PriorityQueue<>((v1,v2)-> v2-v1);
        for (int n : arr){
            if (queue.size()<k){
                //容量未达到k,直接加入堆
                queue.offer(n);
            }else if (n<queue.peek()){
                //达到最大容量k，当前值<堆顶值，则新值入堆，旧堆顶值退出
                queue.poll();
                queue.offer(n);
            }
        }

        int[] ret = new int[k];
        int idx=0;
        for (int n : queue){
            ret[idx++] = n;
        }
        return ret;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
