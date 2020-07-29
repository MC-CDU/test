package cdu.mc.recursive;

/**
 * @author lenovo
 */
public class Test01 {

    public static void main(String[] args) {
        /**
         * 买可乐，1块钱一瓶，每三个瓶盖或两个空瓶子可以换一瓶，问：我有17块最多可以喝多少？
         */
        int test = test(17, 17);
        System.out.println(test + 17);
    }

    public static int test(int pz, int pg) {
        //结束递归的条件
        if (pz < 2 && pg < 3) {
            return 0;
        }
        //获取本次可以用空瓶子换到的饮料数
        int a = pz / 2;
        //获取本次可以用瓶盖换到的饮料数
        int b = pg / 3;
        //本次还剩下的空瓶子数
        int c = pz % 2;
        //本次还剩下的瓶盖数
        int d = pg % 3;
        //本次换到的总饮料数
        int sum = a + b;
        return sum + test(sum + c, sum + d);
    }

}
