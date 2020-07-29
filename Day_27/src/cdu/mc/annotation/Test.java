package cdu.mc.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author lenovo
 */
public class Test {

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        /**
         * NoSuchMethodException:没有对应的方法异常
         * NoSuchFieldException:没有对应的属性异常
         * 通过反射获取类里的方法或者属性是否有某个注解
         */
        Class<MyClass> myClassClass = MyClass.class;
        field(myClassClass,"job");
        field(myClassClass,"name");
        method(myClassClass,"test01");
        method(myClassClass,"test");
    }

    public static void method(Class<MyClass> myClassClass,String methodName) throws NoSuchMethodException {
        Method declaredMethod = myClassClass.getDeclaredMethod(methodName);
        String name = declaredMethod.getName();
        boolean annotationPresent = declaredMethod.isAnnotationPresent(MyAnnotation.class);
        if (annotationPresent) {
            System.out.println(name + "上有MyAnnotation注解");
        }else {
            System.out.println(name + "上没有MyAnnotation注解");
        }
    }

    public static void field(Class<MyClass> myClassClass,String fieldName) throws NoSuchFieldException {
        //获取某个属性
        Field name = myClassClass.getDeclaredField(fieldName);
        name.setAccessible(true);
        String name1 = name.getName();
        boolean annotationPresent = name.isAnnotationPresent(MyAnnotation.class);
        if (annotationPresent) {
            System.out.println(name1 + "属性上有MyAnnotation注解");
        }else {
            System.out.println(name1 + "属性上没有MyAnnotation注解");
        }
    }

}
