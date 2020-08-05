package cdu.mc.io;

import java.util.LinkedList;
import java.util.Random;

/**
 * @author lenovo
 */
public class Test {

    public static void main(String[] args) {

        //生成随机字符串
        char[] chars = {'A','B','C'};
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        //字符串的长度
        int i = random.nextInt(100) + 1;
        for (int i1 = 0; i1 < i; i1++) {
            int i2 = random.nextInt(3);
            //stringBuffer.append(chars[i2]);
        }
        stringBuffer.append("AC");
        LinkedList<Integer> integers = new LinkedList<>();
        System.out.println("原本的字符串：" + stringBuffer);
        test02(chars, stringBuffer, integers);

        int max = integers.getFirst();
        for (Integer integer : integers) {
            if (integer > max) {
                max = integer;
            }
        }
        System.out.println("最高得分：" + max);
    }

    public static void test02(char[] chars, StringBuffer stringBuffer, LinkedList<Integer> integers) {
        StringBuffer stringBuffer1 = null;
        for (int j = 0; j < stringBuffer.length(); j++) {
            for (int k = 0; k < chars.length; k++) {
                stringBuffer.insert(j,chars[k]);
                stringBuffer1 = test(stringBuffer);
                int result = stringBuffer.length() - stringBuffer1.length();
                integers.add(result);
            }
        }
        test02(chars,stringBuffer1,integers);
        if (integers.getLast().equals(integers.get(integers.size() - 1))) {
            return;
        }
    }

    public static StringBuffer test(StringBuffer stringBuffer) {
        String str = stringBuffer.toString();
        char[] chars1 = str.toCharArray();
        for (int i1 = 1; i1 < chars1.length - 1; i1++) {
            int i3 = i1;
            while (i3 >= 1 && chars1[i3 - 1] == chars1[i3]) {
                stringBuffer.setCharAt(i3 - 1,'m');
                stringBuffer.setCharAt(i3,'m');
                i3 = i3 - 1;
            }
            int i4 = i1;
            while (i4 < chars1.length - 1 && chars1[i4 + 1] == chars1[i4]) {
                stringBuffer.setCharAt(i4 + 1,'m');
                stringBuffer.setCharAt(i4,'m');
                i4 = i4 + 1;
            }
        }
        StringBuffer stringBuffer1 = new StringBuffer();
        String s = stringBuffer.toString();
        char[] chars2 = s.toCharArray();
        for (char c : chars2) {
            if (c != 'm') {
                stringBuffer1.append(c);
            }
        }
        if (stringBuffer.length() == stringBuffer1.length()) {
            return stringBuffer1;
        }
        return test(stringBuffer1);
    }

}
