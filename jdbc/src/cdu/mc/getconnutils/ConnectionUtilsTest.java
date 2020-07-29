package cdu.mc.getconnutils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author lenovo
 */
public class ConnectionUtilsTest {

    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionUtils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select count(*) from student");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1));
        }
        ConnectionUtils.close(resultSet,statement,connection);
    }

}
