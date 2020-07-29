package cdu.mc.demo01;

/**
 * @author lenovo
 */
public class Test {

    public static void main(String[] args) {

        MyTree myTree = new MyTree();
        Node a = new Node("A", null, null);
        Node b = new Node("B", null, a);
        Node c = new Node("C", null, a);
        Node d = new Node("D", null, a);
        myTree.add(a);
        myTree.add(b);
        myTree.add(c);
        myTree.add(d);

        myTree.print();
    }

}
