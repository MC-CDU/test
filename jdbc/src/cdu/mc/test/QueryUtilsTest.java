package cdu.mc.test;

import cdu.mc.pojo.Student;
import cdu.mc.pojo.Teacher;
import cdu.mc.querysqlutils.QueryDbUtils;
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

        int query = QueryDbUtils.update("insert into student values(?,?,?,?)", 11, "乔博伦", "1999-12-04", "男");
        System.out.println(query);

    }

    @Test
    public void test01() throws SQLException {
        Student student = QueryDbUtils.queryById("01");
        System.out.println(student);
    }

    @Test
    public void test02() throws SQLException {
        ArrayList<Student> allStudent = QueryDbUtils.findAllStudent();
        for (Student student : allStudent) {
            System.out.println(student);
        }
    }

    @Test
    public void test03(){
        String sql = "select * from student where s_id like ?";
        List<Student> students = QueryDbUtils.queryMethod(sql, Student.class, "%%");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("=================");
        String sql1 = "select * from teacher";
        List<Teacher> teachers = QueryDbUtils.queryMethod(sql1, Teacher.class);
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }
}
