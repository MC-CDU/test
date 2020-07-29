package cdu.mc.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * @author lenovo
 */
public class PropertiesTest {

    public static void main(String[] args) {
        /**
         * 获取properties文件内容方式一：
         * 通过 ResourceBundle.getBundle() 静态方法来获取（ResourceBundle是一个抽象类）
         * 这种方式来获取properties属性文件不需要加.properties后缀名，只需要文件名即可
         */
        System.out.println("方式一：");
        ResourceBundle bundle = ResourceBundle.getBundle("cdu/mc/jdbc/test");
        String username = bundle.getString("username");
        String password = bundle.getString("password");
        System.out.println(username + "-->" + password);

        /**
         * 方式二：
         * 通过PropertyResourceBundle的输入流
         *
         */
        System.out.println("方式二：");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("F:\\idea_project\\qianfeng\\jdbc\\src\\cdu\\mc\\jdbc\\test.properties");
            PropertyResourceBundle propertyResourceBundle = new PropertyResourceBundle(fileInputStream);
            String username1 = propertyResourceBundle.getString("username");
            String password1 = propertyResourceBundle.getString("password");
            System.out.println(username1 + "-->" + password1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * 方式三：
         * 通过Properties的输入流
         */
        System.out.println("方式三：");
        FileInputStream fileInputStream1 = null;
        try {
            fileInputStream1 = new FileInputStream("F:\\idea_project\\qianfeng\\jdbc\\src\\cdu\\mc\\jdbc\\test.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream1);
            String username1 = properties.getProperty("username");
            String password1 = properties.getProperty("password");
            System.out.println(username1 + "-->" + password1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * 方式四：
         * 通过classloader
         */
        System.out.println("方式四:");
        InputStream resourceAsStream = PropertiesTest.class.getClassLoader().getResourceAsStream("cdu/mc/jdbc/test.properties");
        Properties properties = new Properties();
        try {
            properties.load(resourceAsStream);
            String username1 = properties.getProperty("username");
            String password1 = properties.getProperty("password");
            System.out.println(username1 + "-->" + password1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
