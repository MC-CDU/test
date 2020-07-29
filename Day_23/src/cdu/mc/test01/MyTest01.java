package cdu.mc.test01;

/**
 * @author lenovo
 */
public interface MyTest01 {

    /**
     * 接口中的默认方法1
     */
    default void test() {
        System.out.print("hello");
    }

    /**
     * 接口中的默认方法2
     */
    default void test01() {
        System.out.print("\tworld");
    }

    /**
     *
     */
    static void test02() {
        System.out.println("接口中的静态方法");
    }

}
