package cdu.mc.test2;

/**
 * 编号解死锁
 * @author lenovo
 */
public class MyTask implements Runnable {

    MyLock o1 = new MyLock(1);
    MyLock o2 = new MyLock(2);

    @Override
    public void run() {
        if (o1.getId() < o2.getId()) {
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + "获得了o1锁对象");
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + "获得了o2锁对象");
                }
            }
        }else {
            synchronized (o2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "获得了o2锁对象");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + "获得了o1锁对象");
                }
            }
        }

        if (o1.getId() > o2.getId()) {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + "获得了o2锁对象");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + "获得了o1锁对象");
                }
            }
        }else{
            synchronized (o1){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "获得了o1锁对象");
                synchronized (o2){
                    System.out.println(Thread.currentThread().getName() + "获得了o2锁对象");
                }
            }
        }
    }
}
