package cdu.mc.demo;

/**
 * @author lenovo
 */
public class Student extends Person{

    public Student() {
        System.out.println("子类无参");
    }

    public Student(String name) {
        System.out.println("子类有参");
    }

}
