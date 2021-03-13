package com.xiao.linear;

/**
 * @Classname: ListInterface
 * @Description: 线性表接口
 * @Date: 2021/3/10 22:57
 * @Author by kongx
 */
public interface ListInterface<T> {

    /**
     * 判断线性表是否为空
     *
     * @return 空:true;非空:false
     */
    boolean isEmpty();

    /**
     * 获取线性表的长度
     *
     * @return 线性表的长度
     */
    int length();

    /**
     * 获取指定索引处的元素
     *
     * @param i 指定的索引
     * @return 元素对象
     */
    T get(int i);

    /**
     * 设置指定索引处的元素值
     *
     * @param i 指定的索引
     * @param t 元素对象
     */
    void set(int i, T t);

    /**
     * 在指定索引处插入元素
     *
     * @param i 指定的位置
     * @param t 元素对象
     */
    void insert(int i, T t);


    /**
     * 在线性表最后插入元素
     *
     * @param t 元素对象
     */
    void append(T t);

    /**
     * 删除指定索引的元素，若成功则返回删除的元素
     *
     * @param i 指定的索引
     * @return 被删除的元素
     */
    T remove(int i);

    /**
     * 清空线性表
     */
    void removeAll();

    /**
     * 查找指定元素第一次出现的位置
     *
     * @param key 指定查找的元素
     * @return 元素第一次出现的位置索引；若不存在则返回-1
     */
    int indexOf(T key);
}
