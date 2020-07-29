package cdu.mc.test01;

/**
 * @author lenovo
 */
public class Test {

    public static void main(String[] args) {
        Container container = new Container();
        Producers producers = new Producers(container);
        Consumers consumers = new Consumers(container);
        new Thread(producers,"生产者线程1").start();
        new Thread(consumers,"消费者线程1").start();
        new Thread(producers,"生产者线程2").start();
        new Thread(consumers,"消费者线程2").start();
    }

}
class Producers implements Runnable{

    Container container;
    static int i;

    public Producers(Container container){
        this.container = container;
    }

    @Override
    public void run() {
        while(i < 1000) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                container.push(i + "号产品");
                i++;
                continue;
            }
        }
    }
}
class Consumers implements Runnable{

    Container container;
    static int i;

    public Consumers(Container container){
        this.container = container;
    }

    @Override
    public void run() {
        while (i < 1000) {
            synchronized (this) {
                container.pop();
                i++;
                continue;
            }
        }
    }
}