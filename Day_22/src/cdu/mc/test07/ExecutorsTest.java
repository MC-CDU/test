package cdu.mc.test07;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 利用线程池工具类进行创建线程池
 * 本质还是通过ThreadPoolExecutor进行创建的，Executors只是对其进行了封装
 * @author lenovo
 */
public class ExecutorsTest {

    public static void main(String[] args) {

        //创建一个线程池，单个线程重用
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        ExecutorService executorService1 = Executors.newCachedThreadPool();

    }

}
