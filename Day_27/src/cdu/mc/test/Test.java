package cdu.mc.test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author lenovo
 */
public class Test {

    public static <T> T test01(Map<String,Object> map, Class<T> tClass){
        try {
            //获取对象(必须是公有的无参)
            T t1 = tClass.newInstance();
            Set<Map.Entry<String, Object>> entries = map.entrySet();
            for (Map.Entry<String, Object> entry : entries) {
                Field declaredField = tClass.getDeclaredField(entry.getKey());
                //关闭安全检查机制，关闭以后就可以访问该类的私有属性了
                declaredField.setAccessible(true);
                //赋值
                declaredField.set(t1,entry.getValue());
            }
            return t1;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("id","0001");
        map.put("classId","2004");
        Student student = test01(map, Student.class);
        System.out.println(student);
//        map.put("name","马聪");
//        map.put("age",18);
//        map.put("job","java高级工程师");
//        Person person = test01(map, Person.class);
//        System.out.println(person);
    }

}
