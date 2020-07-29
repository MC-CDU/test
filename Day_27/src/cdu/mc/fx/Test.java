package cdu.mc.fx;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        /**
         * 泛型擦除
         * 可以在存储Integer的ArrayList中存储其他类型的数据
         */
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        Class<? extends ArrayList> aClass = arrayList.getClass();
        Method add = aClass.getDeclaredMethod("add", Object.class);
        add.invoke(arrayList,"mc");

        System.out.println(arrayList);
    }
}
