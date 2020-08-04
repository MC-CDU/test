package test;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author lenovo
 */
public class DataSourceTest {

    /**
     * C3P0测试
     */
    @Test
    public void testC3P0(){
        /*
         */
        DataSource dataSource = new ComboPooledDataSource();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Druid测试
     */
    @Test
    public void testDruid(){
        InputStream resourceAsStream = DataSourceTest.class.getClassLoader().getResourceAsStream("myDruid.properties");
        Properties properties = new Properties();
        try {
            properties.load(resourceAsStream);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * DBCP测试
     */
    @Test
    public void testDBCP(){
        Properties properties = new Properties();
        InputStream resourceAsStream = DataSourceTest.class.getClassLoader().getResourceAsStream("MyDBCP.properties");
        try {
            properties.load(resourceAsStream);
            DataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
            System.out.println(dataSource.getConnection());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
