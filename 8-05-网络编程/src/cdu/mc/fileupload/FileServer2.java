package cdu.mc.fileupload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static cdu.mc.fileupload.FileServerDemo.getName;

/**
 * @author lenovo
 */
public class FileServer2 {
    public static void main(String[] args) throws IOException {
        /**
         * 多线程
         */
        //创建线程池
        //计数
        AtomicInteger atomicInteger = new AtomicInteger();
        //队列
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);
        //工厂
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("线程" + atomicInteger.getAndIncrement());
                return thread;
            }
        };
        //拒绝策略
        ThreadPoolExecutor.CallerRunsPolicy callerRunsPolicy = new ThreadPoolExecutor.CallerRunsPolicy();
        ThreadPoolExecutor threadPoolExecutor1 = new ThreadPoolExecutor
                (5, 10, 60, TimeUnit.SECONDS, arrayBlockingQueue, threadFactory,
                        callerRunsPolicy);
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("文件上传服务器开启成功！");
        //等待客户端连接
        while(true) {
            Socket client = serverSocket.accept();
            threadPoolExecutor1.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        InputStream inputStream = client.getInputStream();
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                        //产生一个随机文件名
                        FileOutputStream fileOutputStream = new FileOutputStream("f:\\img\\"+getName()+".jpg");
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                        byte[] buffer = new byte[1024];
                        int len;
                        while((len = bufferedInputStream.read(buffer)) != -1) {
                            bufferedOutputStream.write(buffer,0,len);
                        }
                        System.out.println(Thread.currentThread().getName() + "成功接收来自：" + client.getInetAddress().getHostName() + "的图片！");
                        bufferedOutputStream.close();
                        fileOutputStream.close();
                        bufferedInputStream.close();
                        inputStream.close();
                        client.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
