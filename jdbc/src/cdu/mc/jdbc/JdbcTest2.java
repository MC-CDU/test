package cdu.mc.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author lenovo
 */
public class JdbcTest2 {
    /**
     * 模拟SQL注入
     * 本质就是SQL语句拼接了一个or 恒成立的语句，比如or 1=1
     */
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        Connection conn = JdbcTest.getConn();
        Statement statement = conn.createStatement();
        String sql = "select * from student where s_name="+id;
        //我输入：'赵雷' or 1=1
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet);
        }
    }

}
