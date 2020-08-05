package cdu.mc.datasource;

import cdu.mc.getconnutils.ConnectionUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author lenovo
 */
public class C3P0 {

    public static void main(String[] args) {
        /**
         * c3p0连接池的用法：
         * 1.必须的jar包：
         * c3p0-0.9.5.2.jar
         * mchange-commons-java-0.2.12.jar
         * mysql连接java的jar
         * 2.导入配置文件
         * 必须是c3p0-config.xml，名称必须相同，最好放在项目的根目录下src
         */
        //创建连接池对象，会自动读取c3p0-config.xml配置文件
        DataSource dataSource = new ComboPooledDataSource();
        //创建完连接池对象后，就可以直接从连接池中拿到数据库连接然后再使用
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement("select count(1) from student");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionUtils.close(resultSet,preparedStatement,connection);
        }
    }
}
