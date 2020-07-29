package cdu.mc.annotation;

import java.lang.annotation.*;

/**
 * @author lenovo
 */
//表示该注解可以作用在方法和属性上
@Target({ElementType.METHOD,ElementType.FIELD})
//表示该注解可作用于JVM运行阶段
@Retention(RetentionPolicy.RUNTIME)
//表示会被写入文档
@Documented
//表示被该注解标注的类的子类可以继承父类的该注解
@Inherited
public @interface MyAnnotation {
}
