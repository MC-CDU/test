package cdu.mc.demo01;

import java.util.LinkedList;

/**
 * @author lenovo
 */
public class Node {

    private Object data;
    private LinkedList<Node> next;
    private Node parent;

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node() {

    }

    public Node(Object data, LinkedList<Node> next, Node parent) {
        this.data = data;
        this.next = next;
        this.parent = parent;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public LinkedList<Node> getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next.add(next);
    }
}
