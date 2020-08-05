package cdu.mc.demo1;

import java.util.*;

/**
 * 准备牌阶段：斗地主一般用一副牌，有54张，其中有大王小王各1张，其他52张牌，分别是4个花色，每种花色13张。
 * 四种花色分别为   ，定义一个集合来存储它们；而每一种花色中的13张牌为：（由大到小）2 A K Q J 10 9 8 7 6 5 4 3,
 * 也定义一个集合来存储它们。遍历这两个集合，可以组装成为52张牌，例如7 A
 * 洗牌阶段：使用集合工具类Collections方法，其中static void shuffle(List<?> list)使用指定的随机数对指定列表进行置换，
 * 会随机的打乱集合中的元素的顺序
 * 发牌阶段：要求每一位玩家拥有17张牌，剩余三张作为底牌，一人一张轮流发牌：集合的索引（0-53）%3，
 * 定义4个集合，来存储3个玩家的牌和场上的底牌。索引%3，有三个值（0,1,2），0%3=0，1%3=1，2%3=2，3%3=0，当索引>=51时，改为发底牌
 * 看牌阶段：直接打印集合，遍历存储玩家和底牌的集合
 * @author lenovo
 */
public class Practice {

    public static void main(String[] args) {
        ArrayList<String> color = new ArrayList<>();
        color.add("红桃");
        color.add("黑桃");
        color.add("梅花");
        color.add("方块");

        ArrayList<String> elements = new ArrayList<>();
        for (int i = 3; i <= 10; i++) {
            elements.add(i + "");
        }
        elements.add("J");
        elements.add("Q");
        elements.add("K");
        elements.add("A");
        elements.add("2");

        HashMap<Integer,String> pk = new HashMap<>(54);

        //准备好所有的牌
        int index = 0;
        for (int i1 = 0; i1 < 13; i1++) {
            for (int i2 = 0; i2 < 4; i2++) {
                pk.put(index++,color.get(i2) + elements.get(i1));
            }
        }
        pk.put(52,"小王");
        pk.put(53,"大王");

        Random random1 = new Random();
        Random random = new Random(random1.nextInt(54));
        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 0; i < 54; i++) {
            nums.add(i);
        }

        Collections.shuffle(nums,random);

        ArrayList<Integer> p5 = new ArrayList<>(17);
        ArrayList<Integer> p6 = new ArrayList<>(17);
        ArrayList<Integer> p7 = new ArrayList<>(17);
        ArrayList<Integer> p8 = new ArrayList<>(3);

        ArrayList<String> p1 = new ArrayList<>(17);
        ArrayList<String> p2 = new ArrayList<>(17);
        ArrayList<String> p3 = new ArrayList<>(17);
        ArrayList<String> p4 = new ArrayList<>(3);

        //模拟发牌
        for (int i = 0; i < 54; i++) {
            if (i>=51){
                p8.add(nums.get(i));
            }else if (i%3 == 0){
                p5.add(nums.get(i));
            }else if (i%3 == 1){
                p6.add(nums.get(i));
            }else {
                p7.add(nums.get(i));
            }
        }

        //排序
        Collections.sort(p5);
        Collections.sort(p6);
        Collections.sort(p7);
        Collections.sort(p8);

        for (int i = 0; i < 17; i++) {
            p1.add(pk.get(p5.get(i)));
            p2.add(pk.get(p6.get(i)));
            p3.add(pk.get(p7.get(i)));
        }

        for (int i = 0; i < 3; i++) {
            p4.add(pk.get(p8.get(i)));
        }

        System.out.println("玩家一：");
        System.out.println(p1);
        System.out.println("玩家二：");
        System.out.println(p2);
        System.out.println("玩家三：");
        System.out.println(p3);
        System.out.println("底牌：");
        System.out.println(p4);
    }
}
