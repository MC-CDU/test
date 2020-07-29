package cdu.mc.practice;

/**
 * @author lenovo
 */
public class MyArrayList<It> implements MyCollection{
    /**
     * 容器(默认长度为10)
     */
    private Object[] elements;

    /**
     * 集合中元素的个数
     */
    private int size;

    public MyArrayList(){
        elements = new Object[10];
    }

    public MyArrayList(int capacity) {
        elements = new Object[capacity];
    }

    public int length(){
        return elements.length;
    }

    @Override
    public void add(Object obj) {
        if ((size + 1) == elements.length){
            Object[] newObject = new Object[elements.length*2];
            System.arraycopy(elements,0,newObject,0,elements.length);
            elements = newObject;
        }
        elements[size++] = obj;
    }

    @Override
    public int size() {
        return size;
    }

    public Iterator myIterator(){
        return new Iterator();
    }

    class Iterator implements MyIterator {
        private int point = 0;

        @Override
        public boolean hasNext() {
            return elements[point] != null ;
        }

        @Override
        public Object next() {
            return elements[point++];
        }
    }
}
