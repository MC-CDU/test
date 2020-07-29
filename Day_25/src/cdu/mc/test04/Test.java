package cdu.mc.test04;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author lenovo
 */
public class Test {

    public static void main(String[] args) {
        /**
         * 4）控制台输入一个字符串，统计每个字符出现的个数(5分)
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String str = scanner.next();
        char[] chars = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            int index = 0;
            for (char aChar : chars) {
                if (chars[i] == aChar) {
                    map.put(chars[i],++index);
                }
            }
        }
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }
        scanner.close();
    }
}
