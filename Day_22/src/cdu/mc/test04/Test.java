package cdu.mc.test04;

/**
 * @author lenovo
 */
public class Test {

    public static void main(String[] args) {

        MyTask lockTest = new MyTask();

        Thread t1 = new Thread(lockTest,"线程1");
        Thread t2 = new Thread(lockTest,"线程2");

        t1.start();
        t2.start();

    }

}
