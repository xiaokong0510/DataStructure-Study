package com.xiao.linear;

/**
 * @Classname: SinglyLinkedList
 * @Description: 带头结点的单链表
 * @Date: 2021/3/17 23:27
 * @Author by kongx
 */
public class SinglyLinkedList<T> implements ListInterface<T> {

    /**
     * 头指针，指向单链表的头结点
     */
    public Node<T> head;

    /**
     * 链表长度
     */
    public int length;

    /**
     * 默认构造方法构造空单链表。创建头结点，data和next值均为null
     */
    public SinglyLinkedList() {
        this.head = new Node<>();
        length = 0;
    }

    /**
     * 以数据域数组构造单链表(头尾插入)
     *
     * @param type    0 头插；1 尾插
     * @param element 元素数组
     */
    public SinglyLinkedList(int type, T[] element) {
        this();
        // 头插法
        if (type == 0) {
            // 尾结点
            Node<T> node = new Node<>(element[element.length - 1], null);
            // 从后往前遍历,每构建一个结点，其指针指向之前的结点
            for (int i = element.length - 2; i > 0; i--) {
                node = new Node<>(element[i], node);
            }
            // 头结点指向元首结点
            this.head.next = node;
        }
        // 尾插法
        if (type == 1) {
            Node<T> node = this.head;
            for (T t : element) {
                node.next = new Node<>(t, null);
                node = node.next;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public int length() {
        return length;
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
        // 构建新的结点，让新结点指向位置i的结点
        Node<T> newNode = new Node<T>(t, curr);
        // 让i-1的结点指向新结点
        pre.next = newNode;
        // 一步写法：pre.next = new Node<T>(t,pre.next);
        // 长度+1
        length++;
    }

    /**
     * 在链尾插入一个新元素
     *
     * @param t 元素对象
     */
    @Override
    public void append(T t) {
        Node<T> pre = this.head;
        while (pre.next != null) {
            pre = pre.next;
        }
        pre.next = new Node<>(t, null);
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
        // 让i-1位置的结点指向i+1位置的结点
        pre.next = pre.next.next;
        length--;
        return curr.data;
    }

    @Override
    public void removeAll() {
        this.head.next = null;
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
        String str = "length=" + this.length + "(";
        Node<T> pre = this.head;
        if (this.length > 0) {
            // 元首结点
            pre = pre.next;
            str += pre.data.toString();
            str += ",next:" + pre.next.data.toString();
        }
        while (pre.next != null) {
            str += "; " + pre.next.data.toString();
            if (pre.next.next != null) {
                str += ",next:" + pre.next.next.data.toString();
            } else {
                str += ",next:null";
            }

            pre = pre.next;
        }
        return str + ")";
    }
}
