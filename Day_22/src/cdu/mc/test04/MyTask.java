package cdu.mc.test04;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lenovo
 */
public class MyTask implements Runnable{

    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        try{
            try {
                //判断1秒后是否获得锁
                if (lock.tryLock(1, TimeUnit.SECONDS)){
                    System.out.println(Thread.currentThread().getName() + "获得了锁，开始进行逻辑处理！");
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + "逻辑处理结束");
                }else{
                    System.out.println(Thread.currentThread().getName()+",等待了1秒都没有获得锁");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally {
            lock.unlock();
        }
    }
}
