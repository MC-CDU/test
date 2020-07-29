package cdu.mc.test01;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lenovo
 */
public class Test {

    public static void main(String[] args) {
        /**
         * 1）将两个int型数组合并后按升序排序（5分）
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入两个整数");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        String s = num1 + "" + num2;
        System.out.println(s);
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        for (char c : chars) {
            System.out.print(c + "\t");
        }
        scanner.close();
    }
}
