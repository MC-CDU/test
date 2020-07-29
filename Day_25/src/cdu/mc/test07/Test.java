package cdu.mc.test07;

import java.util.Scanner;

/**
 * @author lenovo
 */
public class Test {
    public static void main(String[] args) {
        /**
         *7）递归实现字符串的反转
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = scanner.next();
        System.out.println("反转前：" + str);
        char[] chars = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        test(chars,stringBuffer,chars.length - 1);
        System.out.println("反转后：" + stringBuffer.toString());
        scanner.close();
    }

    public static void test(char[] chars,StringBuffer stringBuffer,int length) {
        if (chars.length != stringBuffer.length()) {
            stringBuffer.append(chars[length--]);
            test(chars,stringBuffer,length);
        }
    }
}
