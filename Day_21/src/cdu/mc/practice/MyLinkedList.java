package cdu.mc.practice;

/**
 * @author lenovo
 */
public class MyLinkedList implements MyCollection{

    private Node first;
    private Node last;
    private int size;

    @Override
    public void add(Object obj) {
        Node node = new Node(obj, null);
        if (first == null){
            first = node;
        }else{
            last.setNext(node);
        }
        last = node;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    public Iterator myIterator(){
        return new Iterator();
    }

    class Iterator implements MyIterator{

        @Override
        public boolean hasNext() {
            return first != null;
        }

        @Override
        public Object next() {
            Node node = new Node();
            node = first;
            first = first.getNext();
            return node.getElement();
        }
    }
}
