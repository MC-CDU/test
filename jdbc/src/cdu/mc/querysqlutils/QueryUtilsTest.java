package cdu.mc.querysqlutils;

import cdu.mc.pojo.Student;
import cdu.mc.pojo.Teacher;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lenovo
 */
public class QueryUtilsTest {

    public static void main(String[] args) {

        QueryDbUtils queryDbUtils = new QueryDbUtils();
        int query = queryDbUtils.update("insert into student values(?,?,?,?)", 11, "乔博伦", "1999-12-04", "男");
        System.out.println(query);

    }

    @Test
    public void test01() throws SQLException {
        QueryDbUtils queryDbUtils = new QueryDbUtils();
        Student student = queryDbUtils.queryById("01");
        System.out.println(student);
    }

    @Test
    public void test02() throws SQLException {
        QueryDbUtils queryDbUtils = new QueryDbUtils();
        ArrayList<Student> allStudent = queryDbUtils.findAllStudent();
        for (Student student : allStudent) {
            System.out.println(student);
        }
    }

    @Test
    public void test03(){
        QueryDbUtils queryDbUtils = new QueryDbUtils();
        /*
        String sql = "select * from student where s_id like ?";
        List<Student> students = queryDbUtils.queryMethod(sql, Student.class, "%%");
        for (Student student : students) {
            System.out.println(student);
        }
        */


        String sql1 = "select * from teacher";
        List<Teacher> teachers = queryDbUtils.queryMethod(sql1, Teacher.class);
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }
}
