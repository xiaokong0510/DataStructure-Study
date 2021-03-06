package com.xiao.linear.test;

import com.xiao.linear.SequenceList;
import org.junit.Test;

/**
 * @Classname: SequenceListTest
 * @Description: 顺序表测试
 * @Date: 2021/3/9 23:39
 * @Author by kongx
 */
public class SequenceListTest {

    SequenceList<String> s1 = new SequenceList<>();
    @Test
    public void testGet(){
        s1.append("zhangsan");
        s1.append("lisi");
        s1.append("wangwu");
        s1.set(2,"11");
        System.out.println(s1);
        System.out.println(s1.isEmpty());
        System.out.println(s1.length());
        System.out.println(s1.get(0));
        System.out.println(s1.get(5));
        System.out.println(s1.indexOf("lisi"));
    }

    @Test
    public void testInsert(){
        s1.append("zhangsan");
        s1.append("lisi");
        s1.append("wangwu");
        System.out.println(s1);
        s1.insert(2, "zhaoliu");
        System.out.println(s1);
        s1.append("tianqi");
        System.out.println(s1);
    }

    @Test
    public void testRemove(){
        s1.append("zhangsan");
        s1.append("lisi");
        s1.append("wangwu");
        System.out.println(s1);
        System.out.println(s1.remove(1));
        System.out.println(s1);
        s1.removeAll();
        System.out.println(s1);
    }

}
