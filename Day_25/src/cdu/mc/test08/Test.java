package cdu.mc.test08;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author lenovo
 */
public class Test {

    public static void main(String[] args) {
        /**
         * 8）日期和时间：
         * - 如何取得年月日、小时分钟秒？
         * - 如何取得从1970年1月1日0时0分0秒到现在的毫秒数？
         * - 如何取得某月的最后一天？
         * - 如何格式化日期？
         * - 打印昨天的当前时刻？
         */
        //如何取得年月日、小时分钟秒？
        Calendar instance = Calendar.getInstance();
        System.out.println("年:" + instance.get(Calendar.YEAR));
        System.out.println("月:" + (instance.get(Calendar.MONTH) + 1));
        System.out.println("日(今年的多少天):" + instance.get(Calendar.DAY_OF_YEAR));
        System.out.println("日(本月的多少天):" + instance.get(Calendar.DAY_OF_MONTH));
        System.out.println("日(本周的多少天):" + (instance.get(Calendar.DAY_OF_WEEK) - 1));
        System.out.println("时:" + instance.get(Calendar.HOUR_OF_DAY));
        System.out.println("分:" + instance.get(Calendar.MINUTE));
        System.out.println("秒:" + instance.get(Calendar.SECOND));

        System.out.println("=================================");
        //如何取得从1970年1月1日0时0分0秒到现在的毫秒数？
        long l = System.currentTimeMillis();
        System.out.println(l);

        System.out.println("=================================");
        //如何取得某月的最后一天？


        System.out.println("=================================");
        //如何格式化日期？
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println(format);

        System.out.println("=================================");
        //打印昨天的当前时刻
        int year = instance.get(Calendar.YEAR);
        int month = instance.get(Calendar.MONTH) + 1;
        int day = instance.get(Calendar.DAY_OF_MONTH);
        int hour = instance.get(Calendar.HOUR_OF_DAY);
        int min = instance.get(Calendar.MINUTE);
        int s = instance.get(Calendar.SECOND);
        if (min < 10) {
            String s1 = "0" + min;
            if (month < 10) {
                System.out.println(year + "-0" + month + "-" + (day-1) + " " + hour + ":" + s1 + ":" + s);
            }
        }else {
            System.out.println(year + "-" + month + "-" + (day-1) + " " + hour + ":" + min + ":" + s);
        }
    }
}
