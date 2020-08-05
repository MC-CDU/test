package cdu.mc.datasource;

import cdu.mc.getconnutils.ConnectionUtils;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * @author lenovo
 */
public class Druid {

    public static void main(String[] args) {
        /**
         * Druid连接池的使用：
         * 1.导入相关jar：
         * druid-1.1.23.jar
         * 2.设置配置文件，可以设置任意名称的.properties文件，
         * druid不像c3p0默认识别c3p0-config.xml文件。需要自己设置
         * 3.手动读取配置文件
         */
        InputStream resourceAsStream = Druid.class.getClassLoader().getResourceAsStream("myDruid.properties");
        Properties properties = new Properties();
        try {
            //读取配置文件
            properties.load(resourceAsStream);
            //创建连接池对象
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            //打印连接池信息，包括当前连接数、当期连接、正在被使用的连接数等等
            System.out.println(dataSource);
            //从连接池中获取连接
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select count(1) from student");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
            }
            System.out.println(dataSource);
            //关闭使用的资源
            ConnectionUtils.close(resultSet,preparedStatement,connection);
            System.out.println(dataSource);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
