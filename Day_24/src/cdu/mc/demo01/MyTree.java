package cdu.mc.demo01;

import java.util.LinkedList;

/**
 * @author lenovo
 */
public class MyTree {

    private int size;
    private Node head;
    private Node parent;

    public int getSize() {
        return size;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void add(Node node) {
        if (head == null) {
            head = node;
        }else {
            node.setParent(node.getParent());
            node.setNext(node.getNext().getLast());
        }
        size++;
    }

    public void print() {
        Node node = new Node();
        node = head;
        while (node.getNext().size() != 0) {
            System.out.println(node.getData());
            for (Node node1 : node.getNext()) {
                System.out.println(node1.getData());
            }
        }
    }
}
