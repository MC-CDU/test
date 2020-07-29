package cdu.mc.test06;

/**
 * @author lenovo
 */
public class Test {

    public static void main(String[] args) {

//        OneClass instance1 = OneClass.getInstance();
//        OneClass instance2 = OneClass.getInstance();
//        //单例模式，只new了一个对象，所以 true
//        System.out.println(instance1 == instance2);
//
//        System.out.println("=====================");


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(OneClass.getInstance());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(OneClass.getInstance());
            }
        }).start();

        //这时打印的就是两个不同的OneClass对象地址，就破坏了单例模式
    }
}
