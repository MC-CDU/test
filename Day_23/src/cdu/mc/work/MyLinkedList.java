package cdu.mc.work;

/**
 * @author lenovo
 */
public class MyLinkedList {

    private Node first;
    private Node last;
    private int size;

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public void add(Object obj) {
        Node node = new Node(obj, null);
        if (first == null) {
            first = node;
        } else {
            last.setNext(node);
        }
        last = node;
        size++;
    }

    public int size() {
        return size;
    }

    public void print() {
        if (size == 0) {
            System.out.println("该链表还没有存放数据！");
        }
        Node node = first;
        while (node != null) {
            System.out.print(node.getElement() + "\t");
            node = node.getNext();
        }
    }
}
