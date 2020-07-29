package cdu.mc.jdbc;

import java.sql.*;

/**
 * @author lenovo
 */
public class JdbcTest {

    public static Connection getConn(){
        //加载数据库驱动（实际是创建数据库驱动对象Driver），反射不会创建对象，但是会促使类的加载
        Connection conn = null;
        try {
            //底层实现：DriverManager.registerDriver(new Driver());
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/java2004";
            String username = "root";
            String password = "mc123";
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("找不到驱动！");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) throws SQLException {
        Connection conn = getConn();
        String sql = "select * from student where s_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,"01");
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            System.out.print(resultSet.getInt(1));
            System.out.print("\t" + resultSet.getString(2));
            System.out.print("\t" + resultSet.getString(3));
            System.out.print("\t" + resultSet.getString(4));
            System.out.println();
        }
        resultSet.close();
        ps.close();
        conn.close();
    }
}
