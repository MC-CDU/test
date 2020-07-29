package cdu.mc.test05;

/**
 * @author lenovo
 */
public class Test {

    public static void main(String[] args) {

        MyTask myTask = new MyTask();
        Thread t1 = new Thread(myTask, "线程1");
        Thread t2 = new Thread(myTask, "线程2");

        //设置优先级
        t1.setPriority(10);

        t1.start();
        t2.start();

        try {
            Thread.sleep(2000);
            System.out.println("等待时机太久了，让他们不等了");
            t2.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
