package cdu.mc.test03;

/**
 * @author lenovo
 */
public class Test {

    public static void main(String[] args) {
        /**
         * 3）单例模式（2分）
         */
        Girl instance = Girl.getInstance();
        Girl instance1 = Girl.getInstance();
        System.out.println(instance == instance1);
    }
}
class Girl {
    public static Girl girl;
    String name;

    private Girl(String name) {
        this.name = name;
    }

    public static Girl getInstance() {
        if (girl == null) {
            girl = new Girl("桥本环奈");
            return girl;
        }else {
            return girl;
        }
    }
}