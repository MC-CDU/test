package cdu.mc.datasource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author lenovo
 */
public class Dbcp {

    public static void main(String[] args) {
        /**
         * java配置DBCP连接池：
         * 1.导入相关jar
         * commons-collections-3.2.2.jar
         * commons-dbcp-1.4.jar
         * commons-logging-1.1.1.jar
         * commons-pool-1.5.4.jar
         * 2.设置配置文件，这一点和Druid类似
         */
        Properties properties = new Properties();
        InputStream resourceAsStream = Dbcp.class.getClassLoader().getResourceAsStream("MyDBCP.properties");
        Connection connection = null;
        try {
            properties.load(resourceAsStream);
            DataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
            connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select count(1) from student");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
