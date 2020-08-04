package cdu.mc.getconnutils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author lenovo
 */
public class ConnectionUtils {
    private static String url;
    private static String username;
    private static String password;

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("F:\\idea_project\\qianfeng\\jdbc\\src\\cdu\\mc\\getconnutils\\jdbc.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回一个数据库连接对象
     * @return
     */
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 关闭一个connection连接
     * @param connection
     */
    public static void close(Connection connection){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭预编译平台
     * @param preparedStatement
     */
    public static void close(PreparedStatement preparedStatement){
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭普通SQL执行平台
     * @param statement
     */
    public static void close(Statement statement){
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭结果集
     * @param resultSet
     */
    public static void close(ResultSet resultSet){
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭resultSet，preparedStatement，connection
     * @param resultSet
     * @param preparedStatement
     * @param connection
     */
    public static void close(ResultSet resultSet,PreparedStatement preparedStatement,Connection connection){
        close(resultSet);
        close(preparedStatement);
        close(connection);
    }

    /**
     * 关闭resultSet，statement，connection
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void close(ResultSet resultSet,Statement statement,Connection connection){
        close(resultSet);
        close(statement);
        close(connection);
    }

}
