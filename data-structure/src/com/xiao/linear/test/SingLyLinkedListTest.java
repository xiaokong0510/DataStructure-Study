package com.xiao.linear.test;

import com.xiao.linear.SinglyLinkedList;
import org.junit.Test;

/**
 * @Classname: SingLyLinkedListTest
 * @Description: 单链表测试
 * @Date: 2021/3/18 22:55
 * @Author by kongx
 */
public class SingLyLinkedListTest {
    SinglyLinkedList<String> list = new SinglyLinkedList<>();

    @Test
    public void testGet() {
        list.append("张三");
        list.append("李四");
        list.append("王五");
        System.out.println(list);
        System.out.println(list.isEmpty());
        System.out.println(list.length());
        System.out.println(list.get(0));
        System.out.println(list.get(5));
        System.out.println(list.indexOf("王五"));
        list.set(2,"赵六");
        System.out.println(list);
    }

    @Test
    public void testInsert() {
        list.append("zhangsan");
        list.append("lisi");
        list.append("wangwu");
        System.out.println(list);
        list.insert(2, "zhaoliu");
        System.out.println(list);
        list.append("tianqi");
        System.out.println(list);
    }

    @Test
    public void testRemove() {
        list.append("zhangsan");
        list.append("lisi");
        list.append("wangwu");
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
    }

}
