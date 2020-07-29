package cdu.mc.fs;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author lenovo
 */
public class MyTest {

    @Test
    public void test01() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取Class对象的三种方式
        //Class<?> aClass = Class.forName("cdu.mc.fs.Person");
        //Class<Person> aClass = Person.class;
        Class<? extends Person> aClass = new Person().getClass();

        Person person1 = aClass.getDeclaredConstructor().newInstance();
        Person person = aClass.newInstance();
        System.out.println(person1);
        System.out.println(person);
    }
}
