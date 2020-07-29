package cdu.mc.test05;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lenovo
 */
public class MyTask implements Runnable{
    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        try {
            lock.lockInterruptibly();
            try{
                System.out.println(Thread.currentThread().getName() + "获得了锁,进行逻辑处理");
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + "逻辑处理结束");
            }finally {
                lock.unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
