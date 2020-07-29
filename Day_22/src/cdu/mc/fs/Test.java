package cdu.mc.fs;

/**
 * @author lenovo
 */
public class Test {

    public static void main(String[] args) {

        MyTask myThread = new MyTask();
        Thread t1 = new Thread(myThread, "线程1");
        Thread t2 = new Thread(myThread, "线程2");

        t1.start();
        t2.start();
    }

}
