package com.xiao.linear;

/**
 * @Classname: Node
 * @Description: 单链表结点类
 * @Date: 2021/3/17 23:23
 * @Author by kongx
 */
public class Node<T> {
    /**
     * 数据域，存储数据
     */
    public T data;
    /**
     * 指针域，指向后继结点
     */
    public Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public Node() {
        this(null, null);
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}
