1.要么做什么事
    scanner sys.out random
2.要么装数据
    int age = 10;System.out.println("张三的年龄："+age);
    String :可以表示一个字符串
    数组：可以表示一系列数据
    对象：就是携带数据的一种数据结构

   Student[] students = new Student[10];
3.因为数组无法动态扩容，数组的元素个数是写死的
    有了集合ArrayList：基于数组实现，可以动态扩容的数组
    特点：查询快，因为有下标。增删慢，会涉及的下标偏移,线程不安全
    在任意集合中 扩容都很慢，所以以后在使用集合的时候 尽可能减少扩容
4.链表
    node:节点
    链表：增删快，只涉及到前后节点，指针的改变，
            查询慢：没有下标，智能根据指针挨着找
    jdk中LinkedList，双向链表，线程不安全

    list的子类：可以重复，有序
5.迭代子模式

7.set:
    不重复:就是用的map的key
    无序：

6.Map: hashTable(线程安全 过时了)
        HashMap:线程不安全，允许null键值，相同的key会覆盖
        LinkedHashMap:
        TreeMap:二叉树

collections：排序 打乱 这些工具方法
 Collections.shuffle(传入一个集合);
collection:迭代子模式
    list:有序可重复
        ArrayList 、linkedList 、vector（线程安全，过时）

    set:无序不重复
        hashSet、treeSet、LinkedHashSet
        对应的map的key
    queue: 先进先出

Maps工具类
map:Hashtable(过时)、hashMap
   Hashtable： 线程安全，不允许null键值
   hashMap：线程不安全，允许null键值


线程：
1.为什么要用线程？
提高效率

cpu在同一时间只能跑一个线程
电脑现在都是单cpu，多核的

单cpu情况下，多线程能否提高效率？
计算机，分为北桥南桥，
北桥：cpu
南桥：io
多线程就提高了cpu的利用率