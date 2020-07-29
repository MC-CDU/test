package cdu.mc.test06;

/**
 * @author lenovo
 */
public class Test {

    public static void main(String[] args) {
        /**
         * 6）一球从100米高度自由落下，每次落地后反跳回原高度的一半；
         * 再落下，求它在第10次落地时，共经过多少米？第10次反弹多高？（5分）
         */
        double result = 0;
        double height = 100;
        double j = 0;
        for (int i = 0; i < 10; i++) {
            if (i == 9){
                j = high(height);
            }else {
                result += high(height);
                height /= 2;
            }
        }
        System.out.println("总共经过的米数：" + result);
        System.out.println("第10次反弹的高度：" + j);
    }

    public static double high(double height) {
        if (height >  0) {
            return height/2;
        }
        return 0;
    }
}
