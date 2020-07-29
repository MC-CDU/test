package cdu.mc.test;

/**
 * @author lenovo
 */
public class Person {

    private String name;
    private int age;
    public String job;

    public Person() {
    }

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public void show(){
        System.out.println("show show");
    }

    public void eat(String test){
        System.out.println(test + " -> hello world!");
    }

    public String method(String test,int test2){
        return test + "123456789" + test2;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}
