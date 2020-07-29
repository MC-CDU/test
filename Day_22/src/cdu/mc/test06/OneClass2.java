package cdu.mc.test06;

/**
 * 单例模式（全局只使用它的一个对象）
 * @author lenovo
 */
public class OneClass2 {

    private static OneClass2 oneClass;
    /**
     * 私有化构造方法，避免外界new对象，破坏单例模式
     */
    private OneClass2(){}
    /**
     * 返回他的对象，全局唯一
     * @return
     */
    public static OneClass2 getInstance(){
        if (oneClass == null){
            //静态方法，锁的是字节码文件的对象
            synchronized (OneClass2.class){
                if (oneClass == null) {
                    oneClass = new OneClass2();
                }
            }

        }
        return oneClass;
    }
}
