package cdu.mc.practice;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author lenovo
 */
public class MyTest {

    @Test
    public void test01(){
        MyArrayList myArrayList = new MyArrayList();
        for (int i = 0; i < 21; i++) {
            myArrayList.add("元素" + i);
        }
        System.out.println("集合中的元素为： " + myArrayList.size());
        System.out.println("数组的长度为： " + myArrayList.length());
        MyArrayList.Iterator myIterator = myArrayList.myIterator();
        while(myIterator.hasNext()){
            System.out.println(myIterator.next());
        }
    }

    @Test
    public void test02(){
        MyLinkedList myLinkedList = new MyLinkedList();
        for (int i = 0; i < 15; i++) {
            myLinkedList.add("节点"+i);
        }
        System.out.println(myLinkedList.size());
        MyLinkedList.Iterator iterator = myLinkedList.myIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
