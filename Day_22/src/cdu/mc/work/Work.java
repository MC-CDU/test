package cdu.mc.work;

import java.util.Random;
import java.util.Scanner;

/**
 * @author lenovo
 */
public class Work {
    /**
     * 做一个笔试题，欢迎来到2004笔试题现场，请选择你的答题个数 假如输入5，就是5道题
     *
     * 5道计算题 10+11 输入21 提示回答正确 自动弹出下一题（要求题目是自动生成，100以内的加减法）
     *
     * 超时时间：5秒，5秒以后这个题算错误，另外的线程控制，继续回答下一题
     *
     * 最后：统计结果
     */

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        System.out.println("欢迎来到2004笔试题现场");
        System.out.println("请输入你的答题个数：");
        //答题个数
        int count = scan.nextInt();
        //答对题的个数
        int win = 0;

        for (int i = 1; i <= count; i++) {
            System.out.println("第" + i + "题");
            Random random = new Random();
            int i1 = random.nextInt(100);
            int i2 = random.nextInt(100);
            int i3 = random.nextInt(2);
            int result = 0;
            if (i3 == 0) {
                System.out.println(i1 + " + " + i2 + " = ?");
                result = i1 + i2;
            }else {
                System.out.println(i1 + " - " + i2 + " = ?");
                result = i1 - i2;
            }
            MyThread myThread = new MyThread();
            System.out.println("请输入你的答案：");
            boolean control = true;
            myThread.setDaemon(true);
            myThread.start();
            while(control){
                if (!myThread.isAlive()) {
                    System.out.println("超时了");
                    break;
                }
                if (myThread.isAlive()) {
                    int answer = scan.nextInt();
                    if (answer == result) {
                        System.out.println("答对了");
                        win++;
                    }else {
                        System.out.println("答错了");
                    }
                    break;
                }
            }
        }
        System.out.println("答题结束，共答对" + win + "道题");
        scan.close();
    }
}
class MyThread extends Thread{

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
