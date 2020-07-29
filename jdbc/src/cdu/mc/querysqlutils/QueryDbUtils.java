package cdu.mc.querysqlutils;

import cdu.mc.getconnutils.ConnectionUtils;
import cdu.mc.pojo.Student;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lenovo
 */
public class QueryDbUtils {
    private static Connection connection = ConnectionUtils.getConnection();

    public int update(String sql,Object... objects){
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                ps.setObject((i+1),objects[i]);
            }
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionUtils.close(ps);
            ConnectionUtils.close(connection);
        }
        return 0;
    }

    /**
     * 查询单个学生
     * @param id
     * @return
     */
    public Student queryById(String id){
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Student student = new Student();
        try {
            ps = connection.prepareStatement("select * from student where s_id=?");
            ps.setString(1,id);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                student.setS_id(resultSet.getString(1));
                student.setS_name(resultSet.getString(2));
                student.setS_birth(resultSet.getString(3));
                student.setS_sex(resultSet.getString(4));
            }
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionUtils.close(resultSet,ps,connection);
        }
        return null;
    }

    /**
     * 返回所有学生
     * @return
     * @throws SQLException
     */
    public ArrayList<Student> findAllStudent() throws SQLException {
        ArrayList<Student> students = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement("select * from student");
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            Student student = new Student(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
            students.add(student);
        }
        ConnectionUtils.close(resultSet,ps,connection);
        return students;
    }

    /**
     * 封装了一个通用的查询的方法，必须保证数据库的表的字段对应实体类的属性
     * @param sql
     * @param tClass
     * @param objects
     * @param <T>
     * @return
     */
    public <T> List<T> queryMethod(String sql,Class<T> tClass,Object... objects){
        Connection conn = ConnectionUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<T> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            if (objects != null) {
                for (int i = 0; i < objects.length; i++) {
                    ps.setObject(i+1,objects[i]);
                }
            }
            resultSet = ps.executeQuery();
            //获得查询结果集的元数据，包括列的个数，列的名称等等
            ResultSetMetaData metaData = resultSet.getMetaData();
            //获取列的个数
            int columnCount = metaData.getColumnCount();
            //外循环循环的是行
            while (resultSet.next()) {
                //通过反射创建目标对象（无参构造）
                T t = tClass.newInstance();
                //内循环循环的是一行的列
                for (int i = 0; i < columnCount; i++) {
                    Object object = resultSet.getObject(i+1);
                    //获取对应的实体类的属性
                    Field declaredField = tClass.getDeclaredField(metaData.getColumnName(i+1));
                    //关闭安全检查
                    declaredField.setAccessible(true);
                    //给属性赋值，第一参数是要赋值参数的对象，第二个参数是值
                    declaredField.set(t,object);
                }
                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }finally {
            ConnectionUtils.close(resultSet,ps,conn);
        }
        return list;
    }
}
