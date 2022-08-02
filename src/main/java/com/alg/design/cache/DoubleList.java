package com.alg.design.cache;

/**
 * 双向链表
 */
public class DoubleList<K,V> {
    //头尾节点
    private Node<K,V> head,tail;
    //数量
    private int size;

    public DoubleList(){
        head = new Node<>(null , null);
        tail = new Node<>(null , null);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    /**
     * 新增节点到第一个节点
     * @param node
     * @return
     */
    public Node<K,V> addFirst(Node<K,V> node){
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;

        size++;
        return node;
    }

    /**
     * 新增节点到队尾
     * @param node
     * @return
     */
    public Node<K,V> addLast(Node<K,V> node){
        node.prev = tail.prev;
        tail.prev.next=node;
        node.next = tail;
        tail.prev=node;

        size++;
        return node;
    }

    /**
     * 移除
     * @param node
     * @return
     */
    public Node<K,V> remove(Node<K,V> node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
        return node;
    }

    /**
     * 获取第一个元素
     * @return
     */
    public Node<K,V> getFirst(){
        Node<K,V> first = head.next;
        if (first ==null || first==tail) return null;
        return first;
    }

    /**
     * 获取最后一个元素
     * @return
     */
    public Node<K,V> getLast(){
        Node<K,V> last = tail.prev;
        if (last ==null || last==head) return null;
        return last;
    }


    /**
     * 移除最后一个节点
     * @return
     */
    public Node<K,V> removeLast(){
        Node<K,V> last = tail.prev;
        if (last ==null || last==head) return null;
        return remove(last);
    }

    /**
     * 数量
     * @return
     */
    public int getSize(){
        return size;
    }

}
