package com.alg.design.list;

/**
 * 707.设计链表
 */
public class MyLinkedList {
    //当前数量
    int size;
    //头、尾节点
    Node head,tail;

    public MyLinkedList() {
        this.size = 0;
        this.head = new Node(-1);
        this.tail = new Node(-1);
        //指针
        head.next=tail;
        tail.prev=head;
    }

    public int get(int index) {
        Node node = this.getNode(index);
        if (null == node) return -1;
        return node.val;
    }

    /**
     * 增加头节点
     * @param val
     */
    public void addAtHead(int val) {
        addBefore(head.next , val);
    }

    /**
     * 增加尾节点
     * @param val
     */
    public void addAtTail(int val) {
        addBefore(tail,val);
    }

    public void addAtIndex(int index, int val) {
        if (index>size){
            return;
        } else if (index==size){
            addAtTail(val);
        }else if (index<0){
            addAtHead(val);
        }else {
            Node curNode = getNode(index);
            addBefore(curNode,val);
        }
    }

    /**
     * 删除
     * @param index
     */
    public void deleteAtIndex(int index) {
        if (! validateIndex(index))
            return;

        Node node = getNode(index);
        node.prev.next = node.next;
        node.next.prev = node.prev;

        size--;
    }

    /**
     * 当前节点前添加新节点
     * @param curNode 当前节点
     * @param val 新节点值
     * @return 新节点
     */
    private Node addBefore(Node curNode , int val){
        Node newNode = new Node(val);
        newNode.next = curNode;
        newNode.prev = curNode.prev;
        curNode.prev.next=newNode;
        curNode.prev=newNode;

        size++;

        return newNode;
    }

    /**
     * 获取节点
     * @param idx
     * @return
     */
    private Node getNode(int idx){
        //校验是否有效索引
        if (! validateIndex(idx))
            return null;

        Node cur = head;
        while (idx>=0){
            cur = cur.next;
            idx--;
        }
        return cur;
    }

    /**
     * 校验索引是否有效
     * @return
     */
    private boolean validateIndex(int idx){
        return idx>=0 && idx<size;
    }
}

class Node{
    protected int val;
    //后继节点
    protected Node next;
    //前驱节点
    protected Node prev;

    public Node(){};
    public Node(int val){
        this.val = val;
    }
}

