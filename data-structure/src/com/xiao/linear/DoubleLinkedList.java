package com.xiao.linear;

/**
 * @Classname DoubleLinkedList
 * @Description 双向链表
 * @Date 2021/3/24
 * @Author KongX
 * @Version: 1.0.0
 * @see com.xiao.linear.test.DoubleLinkedListTest 测试类
 */
public class DoubleLinkedList<T> implements ListInterface<T> {

    /**
     * 头指针，指向链表的头结点
     */
    private Node<T> head;


    /**
     * 链表长度
     */
    public int length;

    public DoubleLinkedList() {
        this.head = new Node<>();
        this.length = 0;
    }

    /**
     * 双向链表结点类
     *
     * @param <T>
     */
    private static class Node<T> {
        /**
         * 数据域，存储数据
         */
        public T data;
        /**
         * 指针域，指向下一个结点
         */
        public Node<T> next;
        /**
         * 指针域，指向上一个结点
         */
        public Node<T> pre;

        public Node(T data, Node<T> pre, Node<T> next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            String str = "["+this.data.toString()+"]";
            if (this.pre != null && this.pre.data != null) {
                str += ",pre: " + this.pre.data.toString();
            } else {
                str += ",pre: null";
            }
            if (this.next != null) {
                str += ",next: " + this.next.data.toString();
            } else {
                str += ",next: null";
            }
            return str;
        }
    }


    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public T get(int i) {
        if (i < 0 || i >= length) {
            return null;
        }
        // 找到元首节点p
        Node<T> p = this.head.next;
        // p指向第i个结点
        for (int j = 0; j < i; j++) {
            p = p.next;
        }
        return p.data;
    }

    @Override
    public void set(int i, T t) {
        // 不能设置为空对象
        if (t == null) {
            return;
        }
        if (i < 0 || i >= length) {
            throw new IndexOutOfBoundsException(i + "索引非法!");
        }
        // 找到元首节点p
        Node<T> p = this.head.next;
        // p指向第i个结点
        for (int j = 0; j < i; j++) {
            p = p.next;
        }
        p.data = t;
    }

    @Override
    public void insert(int i, T t) {
        // 不能插入空对象
        if (t == null) {
            return;
        }
        if (i < 0 || i > length) {
            throw new IndexOutOfBoundsException(i + "索引非法!");
        }

        Node<T> pre = this.head;
        // 找到位置i-1的结点
        for (int j = 0; j < i; j++) {
            pre = pre.next;
        }
        // 位置i的结点
        Node<T> curr = pre.next;
        // 构建新的结点，让新结点的前驱为 i-1，后继为 i
        Node<T> newNode = new Node<T>(t, pre, curr);
        // 让i-1结点的后继为新结点，原来i节点的前驱为新结点
        pre.next = newNode;
        curr.pre = newNode;
        // 长度+1
        length++;
    }

    @Override
    public void append(T t) {
        Node<T> pre = this.head;
        while (pre.next != null) {
            pre = pre.next;
        }
        pre.next = new Node<>(t, pre, null);
        length++;
    }

    @Override
    public T remove(int i) {
        if (i < 0 || i >= length) {
            return null;
        }
        Node<T> pre = this.head;
        for (int j = 0; j < i; j++) {
            pre = pre.next;
        }
        // i位置的结点
        Node<T> curr = pre.next;
        // 让 i-1 的后继为原 i+1;原 i+1的前驱为 i-1
        pre.next = curr.next;
        curr.next.pre = pre;
        length--;
        return curr.data;
    }

    @Override
    public void removeAll() {
        this.head.data = null;
        this.head.pre = null;
        this.head.next = null;
        this.length = 0;
    }

    @Override
    public int indexOf(T key) {
        Node<T> pre = this.head;
        for (int i = 0; pre.next != null; i++) {
            pre = pre.next;
            if (pre.data.equals(key)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("length=" + this.length + "(");
        Node<T> pre = this.head;
        if (this.length > 0) {
            // 元首结点
            pre = pre.next;
            str.append(pre.toString());
        }
        while (pre.next != null) {
            str.append(";  ").append(pre.next.toString());
            pre = pre.next;
        }
        return str + ")";
    }
}
