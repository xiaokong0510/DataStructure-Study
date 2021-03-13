package com.xiao.linear;

/**
 * @Classname: SequenceList
 * @Description: 顺序表实现
 * @Date: 2021/3/9 22:35
 * @Author by kongx
 * @see com.xiao.linear.test.SequenceListTest 测试类
 */
public class SequenceList<T> implements ListInterface<T> {

    /**
     * 存储元素的数组
     */
    private T[] eleArr;

    /**
     * 当前顺序表元素的个数
     */
    private int count;


    /**
     * 构造函数，创建指定初始容量的空表
     *
     * @param size 初始容量
     */
    public SequenceList(int size) {
        this.eleArr = (T[]) new Object[size];
        this.count = 0;
    }

    /**
     * 无参构造函数. 创建默认容量的空表
     */
    public SequenceList() {
        this(16);
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int length() {
        return this.count;
    }

    @Override
    public T get(int i) {
        if (i < 0 && i >= this.count) {
            return null;
        }
        return this.eleArr[i];
    }

    @Override
    public void set(int i, T t) {
        if (t == null) {
            return;
        }
        if (i < 0 && i >= this.count) {
            throw new IndexOutOfBoundsException(i + "索引非法!");
        }
        this.eleArr[i] = t;
    }

    @Override
    public void insert(int i, T t) {
        if (t == null) {
            return;
        }
        //元素个数等于线性表容量时，插入元素需要扩容
        if (this.count == this.eleArr.length) {
            Object[] temp = this.eleArr;
            //容量扩为原始的2倍
            this.eleArr = (T[]) new Object[temp.length * 2];
            //元素复制
            for (int j = 0; j < temp.length; j++) {
                this.eleArr[j] = (T) temp[j];
            }
        }
        if (i < 0 || i > this.count) {
            throw new RuntimeException("插入的位置不合法！");
        }
        //i位置及其后面的元素依次向后移动一位,从尾部开始
        for (int j = this.count - 1; j >= i; j--) {
            this.eleArr[j + 1] = this.eleArr[j];
        }
        //把t放到i位置处
        this.eleArr[i] = t;
        //元素个数+1
        this.count++;
    }

    @Override
    public void append(T t) {
        this.insert(this.count, t);
    }

    @Override
    public T remove(int i) {
        if (this.count == 0 || i < 0 || i >= this.count) {
            return null;
        }
        //记录索引index处的元素
        T old = this.eleArr[i];
        //i位置后面的元素依次向前移动一位,从i+1处开始
        for (int j = i; j < this.count - 1; j++) {
            this.eleArr[j] = this.eleArr[j + 1];
        }
        //最后一个元素要清空
        this.eleArr[this.count - 1] = null;
        //元素个数-1
        this.count--;
        return old;
    }

    @Override
    public void removeAll() {
        this.count = 0;
    }

    @Override
    public int indexOf(T key) {
        if (key == null) {
            return -1;
        }
        for (int i = 0; i < this.count; i++) {
            if (this.eleArr[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 返回顺序表所有元素描述字符串
     *
     * @return
     */
    @Override
    public String toString() {
        String str = "(";
        if (this.count > 0) {
            str += this.eleArr[0].toString();
        }
        for (int i = 1; i < this.count; i++) {
            str += "," + this.eleArr[i].toString();
        }
        return str + ")";
    }
}
