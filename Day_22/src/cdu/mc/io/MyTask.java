package cdu.mc.io;

/**
 * 模拟死锁
 * @author lenovo
 */
public class MyTask implements Runnable {

    private Object o1 = new Object();
    private Object o2 = new Object();

    @Override
    public void run() {
        synchronized (o1){
            System.out.println(Thread.currentThread().getName() + "获得了o1锁对象");
            synchronized (o2){
                System.out.println(Thread.currentThread().getName() + "获得了o2锁对象");
            }
        }

        synchronized (o2){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "获得了o2锁对象");
            synchronized (o1){
                System.out.println(Thread.currentThread().getName() + "获得了o1锁对象");
            }
        }

    }
}
