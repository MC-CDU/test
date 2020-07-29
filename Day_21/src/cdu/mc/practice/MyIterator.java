package cdu.mc.practice;

/**
 * @author lenovo
 */
public interface MyIterator {

    /**
     * 判断是否有下一个元素
     * @return
     */
    boolean hasNext();

    /**
     * 返回下一个节点
     * @return
     */
    Object next();

}
