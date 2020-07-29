package cdu.mc.test;

/**
 * @author lenovo
 */
public class Student {

    public String id;

    private String classId;

    public Student() {
    }

    public Student(String id, String classId) {
        this.id = id;
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", classId='" + classId + '\'' +
                '}';
    }
}
