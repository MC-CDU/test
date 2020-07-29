package cdu.mc.test;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author lenovo
 */
public class MyTest {

    @Test
    public void test(){
        Class<Person> personClass = Person.class;
        try {
            //这种方式获取到的无参构造必须是公有的
            Person person = personClass.newInstance();
            System.out.println(person);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test01() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        /**
         * 通过反射调用无参构造创建对象
         */
        Class<Person> aClass = Person.class;
        Constructor<Person> declaredConstructor = aClass.getDeclaredConstructor();
        Person person = declaredConstructor.newInstance();
        System.out.println(person);
    }

    @Test
    public void test02() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        /**
         * 通过反射调用有参构造创建对象
         */
        Class<? extends Person> aClass = new Person().getClass();
        Constructor<? extends Person> declaredConstructor = aClass.getDeclaredConstructor(String.class, int.class, String.class);
        //这里如果遇到构造方法是是私有的情况，那么就要关闭安全检查机制
        //declaredConstructor.setAccessible(true); 默认false 是开启状态
        Person person = declaredConstructor.newInstance("马聪", 19, "java高级工程师");
        System.out.println(person);
    }

    @Test
    public void test03(){
        /**
         * 通过反射获取到属性，并进行赋值
         */
        try {
            Person person = new Person();
            Class<?> aClass = Class.forName("cdu.mc.test.Person");
            Field[] declaredFields = aClass.getDeclaredFields();
            System.out.println("获取所有属性(包括私有)：");
            for (Field field : declaredFields) {
                System.out.println(field);
            }
            System.out.println("获取所有公有的属性：");
            Field[] fields = aClass.getFields();
            for (Field field : fields) {
                System.out.println(field);
            }
            System.out.println("===================");
            Field name = aClass.getDeclaredField("name");
            name.setAccessible(true);
            name.set(person,"马聪");
            System.out.println(person);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test04() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        /**
         * 通过反射获取方法
         */
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();
        Method show = personClass.getDeclaredMethod("show");
        //如果是私有的方法就要关闭安全检查
        Object invoke = show.invoke(person);
        //因为该方法没有返回值，会返回null
        System.out.println(invoke);
    }

    @Test
    public void test05() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        /**
         * 通过反射获取方法，传参
         */
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();
        Method eat = personClass.getDeclaredMethod("eat", String.class);
        eat.invoke(person,"有参有参");
    }

    @Test
    public void test06() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        /**
         * 多个参数，带返回值的方法，如果没有返回值，就返回null
         */
        Class<Person> aClass = Person.class;
        Person person = aClass.newInstance();
        Method method = aClass.getDeclaredMethod("method", String.class, int.class);
        Object invoke = method.invoke(person, "马聪", 996);
        System.out.println(invoke);
    }

    @Test
    public void test07(){

    }

}
