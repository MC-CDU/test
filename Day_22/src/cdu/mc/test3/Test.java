package cdu.mc.test3;

/**
 * @author lenovo
 */
public class Test {

    public static void main(String[] args) {

        LockTest lockTest = new LockTest();

        Thread t1 = new Thread(lockTest,"线程1");
        Thread t2 = new Thread(lockTest,"线程2");

        t1.start();
        t2.start();

    }

}
