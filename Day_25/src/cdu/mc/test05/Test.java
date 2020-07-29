package cdu.mc.test05;

/**
 * @author lenovo
 */
public class Test {

    public static void main(String[] args) {
        /**
         * 5）多线程实现两个窗口卖票（5分）
         */
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.setName("窗口1");
        t2.setName("窗口2");
        t1.start();
        t2.start();
    }
}
class MyThread extends Thread{
    static int counts = 100;
    @Override
    public void run() {
        while (counts >= 1) {
            synchronized (MyThread.class) {
                if (counts == 0) {
                    break;
                }
                System.out.println(Thread.currentThread().getName() + "正在卖第" + counts-- + "张票");
            }
        }
    }
}