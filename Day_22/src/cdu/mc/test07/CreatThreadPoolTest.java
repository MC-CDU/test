package cdu.mc.test07;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lenovo
 */
public class CreatThreadPoolTest {

    public static void main(String[] args) {
        //计数
        AtomicInteger integer = new AtomicInteger();

        //创建任务队列
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);
        //创建线程工厂
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("成都大学" + integer.getAndIncrement());
                return thread;
            }
        };

        //拒绝策略，就是当线程池里面的所有线程都在运行的时候，还是有任务进来（总任务数 > 最大线程数 + 任务队列的长度），这时就要执行拒绝策略，CallerRunsPolicy表示由调用线程处理
        ThreadPoolExecutor.CallerRunsPolicy callerRunsPolicy = new ThreadPoolExecutor.CallerRunsPolicy();

        //创建线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,10,
                60, TimeUnit.SECONDS,arrayBlockingQueue,threadFactory,callerRunsPolicy);

        //提交任务执行(一瞬间)
        //任务数量
        int taskCount = 100;
        for (int i = 0; i < taskCount; i++) {
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "在执行任务");
                }
            });
        }

        //关闭线程池
        threadPoolExecutor.shutdown();
    }

}
