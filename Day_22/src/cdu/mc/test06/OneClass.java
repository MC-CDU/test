package cdu.mc.test06;

/**
 * 单例模式（全局只使用它的一个对象）
 * @author lenovo
 */
public class OneClass {

    private static OneClass oneClass;
    /**
     * 私有化构造方法，避免外界new对象，破坏单例模式
     */
    private OneClass(){}
    /**
     * 返回他的对象，全局唯一
     * @return
     */
    public static OneClass getInstance(){
        if (oneClass == null){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            oneClass = new OneClass();
        }
        return oneClass;
    }
}
