package cdu.mc.jdbc;

import cdu.mc.getconnutils.ConnectionUtils;
import org.junit.Test;

import java.sql.*;

/**
 * @author lenovo
 */
public class MyTest {

    public static void main(String[] args) {
        //加载驱动（实际上就是创建Driver对象）
        //通过反射获取到com.mysql.cj.jdbc.Driver的Class对象，会促使该类的加载，首先就会加载静态属性和
        //静态代码块，核心代码就是：DriverManager.registerDriver(new Driver());
        //即：调用了DriverManager类的registerDriver()方法，并传入了一个Driver类的对象
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //这时候要处理一个ClassNotFoundException
            Class.forName("com.mysql.cj.jdbc.Driver");
            //通过DriverManager创建连接
            //处理SQLException
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/java2004", "root", "mc123");
            //创建SQL的执行平台
            preparedStatement = conn.prepareStatement("select count(s_id) from student");
            //执行SQL并返回查询到的结果集
            resultSet = preparedStatement.executeQuery();
            //遍历结果集
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭所有资源
            ConnectionUtils.close(resultSet,preparedStatement,conn);
        }
    }

    @Test
    public void test(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/java2004", "root", "mc123");
            preparedStatement = connection.prepareStatement("select count(s_id) from student");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                System.out.println(resultSet.getInt(1));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
