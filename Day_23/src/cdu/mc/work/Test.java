package cdu.mc.work;

/**
 * 单向链表反转（递归实现）
 *
 * @author lenovo
 */
public class Test {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        for (int i = 0; i < 10; i++) {
            myLinkedList.add("节点" + i);
        }
        MyLinkedList myLinkedList1 = new MyLinkedList();
        System.out.println("原链表：");
        myLinkedList.print();
        System.out.println("\n转换后的链表");
        MyLinkedList test = test(myLinkedList, myLinkedList1, myLinkedList.size() - 1);
        test.print();
    }

    public static MyLinkedList test(MyLinkedList myLinkedList, MyLinkedList myLinkedList1, int size) {
        if (size >= 1) {
            Node node = myLinkedList.getFirst();
            for (int i = size; i >= 1; i--) {
                node = node.getNext();
            }
            myLinkedList1.add(node.getElement());
            test(myLinkedList, myLinkedList1, --size);
        } else {
            myLinkedList1.add(myLinkedList.getFirst().getElement());
        }
        return myLinkedList1;
    }

}
