package cdu.mc.test01;

/**
 * 装产品的容器
 * @author lenovo
 */
public class Container {

    Object[] objects = new Object[10];
    int point = 0;

    public synchronized void push(Object o){
        if (point == objects.length) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        objects[point++] = o;
        System.out.println(Thread.currentThread().getName() + "生产了" + o);
        notifyAll();
    }

    public synchronized Object pop(){
        if (point == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Object object = objects[--point];
        System.out.println(Thread.currentThread().getName() + "消费了" + object);
        notifyAll();
        return object;
    }

}
