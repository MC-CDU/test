package cdu.mc.work;

import java.util.Scanner;

/**
 * @author lenovo
 */
public class Test {

    @org.junit.Test
    public void test() throws InterruptedException {
        MyThread1 myThread1 = new MyThread1();
        myThread1.setDaemon(true);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数据：");
        myThread1.start();

        int num = scanner.nextInt();
        System.out.println("num:" + num);
        System.out.println(myThread1.isAlive());
    }

    @org.junit.Test
    public void test02(){


    }

    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        myThread1.setDaemon(true);
        boolean con = true;
        Scanner scanner = new Scanner(System.in);

        myThread1.start();

        System.out.println("请输入数据：");
        while(con){
            if (!myThread1.isAlive()){
                int num = scanner.nextInt();
                System.out.println("num:" + num);
                con = false;
                System.out.println("超时了");
            }
        }

        System.out.println(myThread1.isAlive());
    }

}
class MyThread1 extends Thread{

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}